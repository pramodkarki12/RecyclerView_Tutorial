package com.pramodkarki.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.pramodkarki.tutorial.adapters.RecipeAdapter;
import com.pramodkarki.tutorial.classes.RecyclerItemClickListener;
import com.pramodkarki.tutorial.databinding.ActivityMainBinding;
import com.pramodkarki.tutorial.models.FoodRecipe;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /** set the ArrayList<FoodRecipe> to store the data,
         * either from database, or custom implementation
         * */
        ArrayList<FoodRecipe> list = new ArrayList<>();

        /**
         * call the FoodRecipe constructor and set the data into it.
         * Then, add the following data into the ArrayList<FoodRecipe>.
         */
        list.add(new FoodRecipe(R.drawable.food_1, "Burger"));
        list.add(new FoodRecipe(R.drawable.food_2, "Coca-Cola"));
        list.add(new FoodRecipe(R.drawable.food_3, "Pizza"));
        list.add(new FoodRecipe(R.drawable.food_4, "Chicken Curry"));
        list.add(new FoodRecipe(R.drawable.food_5, "Salad"));
        list.add(new FoodRecipe(R.drawable.food_6, "Boiling Fish"));
        list.add(new FoodRecipe(R.drawable.food_7, "Cracks & Nuts"));
        list.add(new FoodRecipe(R.drawable.food_8, "Delicious Food"));

        /**
         * Here, we call the constructor of RecipeAdapter which takes
         * the ArrayList<FoodRecipe> where we stored data, and
         * the context where the recycleView will be displayed.
         */
        RecipeAdapter adapter = new RecipeAdapter(list, this);
        binding.recycleView.setAdapter(adapter); // link the adapter with the recycleView

        /**
         * Now, we need to include the layoutManager to display the recycleView.
         * LayoutManager comes with different layout styles:
         *  1. LinearLayoutManager (both horizontal and vertical) => by default, it is set as vertical
         *  2. GridLayoutManager
         *  3. StaggeredGridLayoutManager
         */


        /** LET'S HAVE A LOOK AT "LINEARLAYOUTMANAGER". */

        /** By default, LinearLayoutManager is set in the vertical position.
         * This following code calls the LinearLayoutManager
         * and binds/links with the recycleView.
         */

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(layoutManager);

        /**
         * When we want to display the Horizontal LinearLayout,
         * we need to pass the context, direction and reverseLayout.
         *
         * @params context This is the place/activity to show the recycleView
         * @params direction This helps to indicate on which direction
         *                      we need to set the LinearLayoutManager,
         *                      either Horizontal or Vertical
         * @params reverseLayout It takes the boolean value.
         *                      When it is set as "false" in horizontal direction, we can scroll the
         *                      item in right side direction only.
         *                      But if it is set as "true" in horizontal direction, it supports
         *                      both the side while scrolling , i.e., left and right
         *
         */
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.recycleView.setLayoutManager(layoutManager);*/


        /** LET'S HAVE A LOOK INTO "GRIDLAYOUTMANAGER"*/

        /**
         * In GridLayoutManager, we provide the context and,
         * the number of grid/columns we need to display.
         */
        /*GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.recycleView.setLayoutManager(layoutManager);*/


        /** LET'S HAVE A LOOK AT "STAGGEREDGRIDLAYOUTMANAGER". */

        /**
         * StaggeredGridLayoutManager is the advanced form of GridLayoutManager.
         * In staggeredGridLayoutManager, it supports both Horizontal and Vertical scrolling activity.
         * Same as GridLayoutManager, we provide the spanCount i.e., the number of grid/columns,
         * and scrolling orientation i.e., horizontal or vertical
         */
        /*StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        binding.recycleView.setLayoutManager(layoutManager);*/


        /**
         * "OnItemTouchListener" can be useful for apps that want to manipulate touch events,
         * and gestures to perform specific tasks.
         *
         * This can be useful for applications that wish to implement
         * various forms of gestural manipulation of item views within the RecyclerView.
         * OnItemTouchListeners may intercept a touch interaction already in progress
         * even if the RecyclerView is already handling that gesture stream itself
         * for the purposes of scrolling.
         *
         * Here, we can perform different functionality or displayed new activity while clicked,
         * on different items.
         * When we perform onClickListener for different item inside the "RecipeAdapter" class,
         * we were not able to perform link different activity for each respective items.
         *
         * Simply, we can say, it overrides the "onClickListener".
         *
         */
        binding.recycleView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, binding.recycleView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                switch (position) {
                                    case 0:
                                        Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                                        startActivity(intent);
                                        break;

                                    case 1:
                                        Toast.makeText(MainActivity.this, "Second Item is clicked", Toast.LENGTH_SHORT).show();
                                        break;

                                    case 2:
                                        Toast.makeText(MainActivity.this, "Third Item is clicked", Toast.LENGTH_SHORT).show();
                                        break;

                                    default:
                                }
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                /**
                                 * When user click on item for long item,
                                 * you can performs different functionality.
                                 */
                                switch (position) {
                                    case 0:
                                        Toast.makeText(MainActivity.this, "Congratulations !! You get 10% Discount", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                }
                            }
                        }));
    }
}