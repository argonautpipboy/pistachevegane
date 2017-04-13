package app.pistachevegane.com.components;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.pistachevegane.com.R;
import app.pistachevegane.com.model.VeganProduct;

public class VeganProductListAdapter extends ArrayAdapter<VeganProduct> implements Filterable {
    private List<VeganProduct> mOriginalValues; // Original Values
    private List<VeganProduct> mDisplayedValues;    // Values to be displayed
    LayoutInflater inflater;
    private Context context;

    public VeganProductListAdapter(Context context, List<VeganProduct> mVeganProductArray) {
        super(context, R.layout.item_veganproduct, mVeganProductArray);
        this.mOriginalValues = mVeganProductArray;
        this.mDisplayedValues = mVeganProductArray;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return mDisplayedValues.size();
    }

    @Override
    public VeganProduct getItem(int position) {
        return mDisplayedValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDisplayedValues.get(position).hashCode();
    }

    private class ViewHolder {
        TextView titleVeganProduct;
        TextView typeVeganProduct;
        TextView sourceVeganProduct;
        TextView backgroundLeftVeganProduct;
        TextView backgroundRightVeganProduct;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        VeganProductListAdapter.ViewHolder holder = null;

        if (convertView == null) {
            holder = new VeganProductListAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_veganproduct, null);
            holder.titleVeganProduct = (TextView) convertView.findViewById(R.id.item_veganproduct_titleVeganProduct);
            holder.typeVeganProduct = (TextView) convertView.findViewById(R.id.item_veganproduct_typeVeganProduct);
            holder.sourceVeganProduct = (TextView) convertView.findViewById(R.id.item_veganproduct_sourceVeganProduct);
            holder.backgroundLeftVeganProduct = (TextView) convertView.findViewById(R.id.item_veganproduct_backgroundLeft);
            holder.backgroundRightVeganProduct = (TextView) convertView.findViewById(R.id.item_veganproduct_backgroundRight);
            convertView.setTag(holder);
        } else {
            holder = (VeganProductListAdapter.ViewHolder) convertView.getTag();
        }

        holder.titleVeganProduct.setText(mDisplayedValues.get(position).getTitleProduct());
        holder.typeVeganProduct.setText(mDisplayedValues.get(position).getTypeProduct());
        holder.sourceVeganProduct.setText(mDisplayedValues.get(position).getSourceProduct());
        if(mDisplayedValues.get(position).getSourceProduct().equals(context.getResources().getString(R.string.veganproduct_source_animal))){
            holder.backgroundLeftVeganProduct.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWrong));
            holder.backgroundRightVeganProduct.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWrong));
        } else{
            holder.backgroundLeftVeganProduct.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSurroundCard));
            holder.backgroundRightVeganProduct.setBackgroundColor(ContextCompat.getColor(context, R.color.colorSurroundCard));
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,Filter.FilterResults results) {
                mDisplayedValues = (ArrayList<VeganProduct>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<VeganProduct> filteredArrList = new ArrayList<VeganProduct>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<VeganProduct>(mDisplayedValues); // saves the original data in mOriginalValues
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
                        if (mOriginalValues.get(i).getTitleProduct().toLowerCase().contains(constraint.toString()) ||
                                mOriginalValues.get(i).getTypeProduct().toLowerCase().contains(constraint.toString())) {
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
    }
}
