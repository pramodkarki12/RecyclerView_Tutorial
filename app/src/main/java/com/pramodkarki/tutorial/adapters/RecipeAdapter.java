package com.pramodkarki.tutorial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pramodkarki.tutorial.R;
import com.pramodkarki.tutorial.models.FoodRecipe;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.viewHolder> {

    ArrayList<FoodRecipe> foodList;
    Context context;

    public RecipeAdapter(ArrayList<FoodRecipe> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    /**
     * "onCreateViewHolder()" creates a new ViewHolder object
     * whenever the RecyclerView needs a new one.
     * This is the moment when the row layout is inflated,
     * passed to the ViewHolder object and each child view can be found and stored.
     */
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * This code basically inflate the "sample_recycle_view" to the context
         * and returns the type of "viewHolder"
         * */
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycle_view, parent, false);
        return new viewHolder(view);
    }

    /**
     * "onBindViewHolder()" takes the ViewHolder object and
     * sets the proper list data for the particular row on the views inside.
     * <p>
     * Initially you will get new unused view holders and
     * you have to fill them with data you want to display.
     * But as you scroll you'll start getting view holders
     * that were used for rows that went off screen and
     * you have to replace old data that they held with new data.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.viewHolder holder, int position) {

        /**
         * First, get the data from the ArrayList<FoodRecipe> based on their position,
         * and stored them inside the FoodRecipe Model.
         *
         * Now, we will set the data into their respective view type i.e., imageView and textView
         */
        FoodRecipe model = foodList.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getTitle());

        /**
         * Suppose you want to perform the "same click event to all the imageView",
         * then you can follow the following code. If we click on imageView of any item,
         * the following toast message will be displayed.
         */
        /*holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

        /**
         * Otherwise, if you want to perform "different click event for different item",
         * then we provide different functionality to different item based on their positions.
         *
         * Here, positions gives the indexing number of clicked item.
         */
        switch (position) {
            case 0:
                // click event on imageView
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "ImageView One is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                // click event on textView
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "TextView One is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            case 1:
                // click event on imageView
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "ImageView Two is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                // click event on textView
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "TextView Two is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

            default:
        }
    }

    /**
     * getItemCount() returns the total number of the list size.
     * The list values are passed by the constructor.
     */

    @Override
    public int getItemCount() {
        /* configure the size of the list */
        return foodList.size();
    }

    /**
     * ViewHolder design pattern is used to
     * speed up rendering of your ListView - actually to make it
     * work smoothly, findViewById is quite expensive (it does DOM parsing)
     * when used each time a list item is rendered, it must traverse your layout hierarchy and
     * also instantiate objects. Since lists can redraw its items quite frequently during scrolling
     * such overhead might be substantial.
     * <p>
     * Your code might call findViewById() frequently during the scrolling of ListView,
     * which can slow down performance. Even when the Adapter returns an inflated view for recycling,
     * you still need to look up the elements and update them.
     * A way around repeated use of findViewById() is to use the "view holder" design pattern.
     */
    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        /* Configure your design view id i.e., image & text  */
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
