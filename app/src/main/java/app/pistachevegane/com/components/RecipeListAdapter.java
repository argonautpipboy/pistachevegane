package app.pistachevegane.com.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.pistachevegane.com.R;
import app.pistachevegane.com.model.Recipe;

public class RecipeListAdapter extends ArrayAdapter<Recipe> implements Filterable {
    private List<Recipe> mOriginalValues; // Original Values
    private List<Recipe> mDisplayedValues;    // Values to be displayed
    LayoutInflater inflater;

    public RecipeListAdapter(Context context, List<Recipe> mRecipeArray) {
        super(context, R.layout.item_recipe, mRecipeArray);
        this.mOriginalValues = mRecipeArray;
        this.mDisplayedValues = mRecipeArray;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDisplayedValues.size();
    }

    @Override
    public Recipe getItem(int position) {
        return mDisplayedValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDisplayedValues.get(position).hashCode();
    }

    private class ViewHolder {
        ImageView imageCardRecipe;
        TextView titleCardRecipe;
        ImageView typeCardRecipe;
        ImageView timeCardRecipe;
        ImageView complexityCardRecipe;
        LinearLayout titleConainterCardRecipe;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_recipe, null);
            holder.titleConainterCardRecipe = (LinearLayout) convertView.findViewById(R.id.titleContainerCardRecipe);
            holder.imageCardRecipe = (ImageView) convertView.findViewById(R.id.imageCardRecipe);
            holder.titleCardRecipe = (TextView) convertView.findViewById(R.id.titleCardRecipe);
            holder.typeCardRecipe = (ImageView) convertView.findViewById(R.id.typeCardRecipe);
            holder.timeCardRecipe = (ImageView) convertView.findViewById(R.id.timeCardRecipe);
            holder.complexityCardRecipe = (ImageView) convertView.findViewById(R.id.complexityCardRecipe);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //holder.imageCardRecipe.setImageDrawable(getContext().getResources().getDrawable(getContext().getResources()
        //        .getIdentifier("d002_p00"+mDisplayedValues.get(position).getIdentifierDrawablePicture(), "drawable", getContext().getPackageName())));
        holder.titleCardRecipe.setText(mDisplayedValues.get(position).getTitle());
        holder.typeCardRecipe.setImageDrawable(getImageType(mDisplayedValues.get(position).getType()));
        holder.timeCardRecipe.setImageDrawable(getImageTime(mDisplayedValues.get(position).getTimeToCook()));
        holder.complexityCardRecipe.setImageDrawable(getImageComplexity(mDisplayedValues.get(position).getComplexity()));

        return convertView;
    }

    private Drawable getImageType(String type){
        Drawable result = getContext().getResources().getDrawable(R.drawable.img_ic_photos);
        switch(type){
            case "ENTREE":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_cat_1);
                break;
            case "PLAT":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_cat_2);
                break;
            case "DESSERT":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_cat_3);
                break;
        }
        return result;
    }

    private Drawable getImageTime(Integer type){
        Drawable result = getContext().getResources().getDrawable(R.drawable.img_ic_photos);
        switch(type){
            case 5:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_5m);
                break;
            case 10:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_10m);
                break;
            case 20:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_20m);
                break;
            case 30:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_30m);
                break;
            case 45:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_45m);
                break;
            case 60:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_60m);
                break;
            case 90:
                result = getContext().getResources().getDrawable(R.drawable.img_recette_time_90m);
                break;
        }
        return result;
    }

    private Drawable getImageComplexity(String type){
        Drawable result = getContext().getResources().getDrawable(R.drawable.img_ic_photos);
        switch(type){
            case "VEASY":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_dif_1);
                break;
            case "EASY":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_dif_2);
                break;
            case "HARD":
                result = getContext().getResources().getDrawable(R.drawable.img_recette_dif_3);
                break;
        }
        return result;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,Filter.FilterResults results) {
                mDisplayedValues = (ArrayList<Recipe>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Recipe> filteredArrList = new ArrayList<Recipe>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<Recipe>(mDisplayedValues); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {
                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        String data = mOriginalValues.get(i).getTitle();
                        if (data.toLowerCase().contains(constraint.toString())) {
                            filteredArrList.add(mOriginalValues.get(i));
                        }
                    }
                    // set the Filtered result to return
                    results.count = filteredArrList.size();
                    results.values = filteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}