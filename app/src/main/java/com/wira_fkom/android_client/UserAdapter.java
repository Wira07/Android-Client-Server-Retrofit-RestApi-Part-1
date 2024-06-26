package com.wira_fkom.android_client;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;
    private Context context;
    private MainActivity mainActivity;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;

        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textViewName.setText(user.getName());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewAlamat.setText(user.getAlamat());
        holder.textViewTelepon.setText(user.getTelepon());

        // Load image using Glide
        Glide.with(context)
                .load(user.getGambar())
                .placeholder(R.drawable.ic_launcher_background) // Optional: a placeholder image
                .error(R.drawable.ic_launcher_background) // Optional: an error image
                .into(holder.imageViewProfile);

        // Load image using Picasso
        // Picasso.get().load(user.getGambar()).placeholder(R.drawable.placeholder_image).error(R.drawable.error_image).into(holder.imageViewProfile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showUpdateDialog(user);
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog(user.getId());
            }
        });
    }

    private void showDeleteConfirmationDialog(final int userId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete User");
        builder.setMessage("Are you sure you want to delete this user?");

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteUser(userId);
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void deleteUser(int userId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Void> call = apiService.deleteUser(userId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < userList.size(); i++) {
                        if (userList.get(i).getId() == userId) {
                            userList.remove(i);
                            notifyItemRemoved(i);
                            break;
                        }
                    }
                    Toast.makeText(context, "User deleted successfully", Toast.LENGTH_SHORT).show();
                    if (mainActivity != null) {
                        mainActivity.fetchUsers();
                    }
                } else {
                    Toast.makeText(context, "Failed to delete user: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to delete user: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewEmail;
        public TextView textViewAlamat;
        public TextView textViewTelepon;
        public ImageView imageViewProfile;
        public Button buttonDelete;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewAlamat = itemView.findViewById(R.id.textViewAlamat);
            textViewTelepon = itemView.findViewById(R.id.textViewTelepon);
            imageViewProfile = itemView.findViewById(R.id.imageViewProfile);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
