package com.example.administrator.foldingcellandroiddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();

    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);

        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;

        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);

            viewHolder.titleImageView = cell.findViewById(R.id.titleImageView);
            viewHolder.titleTextView = cell.findViewById(R.id.titleTextView);
            viewHolder.contentTextView = cell.findViewById(R.id.contentTextView);
            viewHolder.contentImageView = cell.findViewById(R.id.contentImageView);
            viewHolder.contentAreaTextView = cell.findViewById(R.id.contentAreaTextView);
            viewHolder.contentIntroductionTextView = cell.findViewById(R.id.contentIntroductionTextView);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == item)
            return cell;

        viewHolder.titleImageView.setImageResource(item.getTitleImage());
        viewHolder.titleTextView.setText(item.getTitleText());
        viewHolder.contentTextView.setText(item.getTitleText());
        viewHolder.contentImageView.setImageResource(item.getCotentImage());
        viewHolder.contentAreaTextView.setText(item.getContentText1());
        viewHolder.contentIntroductionTextView.setText(item.getContentText2());

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    // View lookup cache
    private static class ViewHolder {
        ImageView titleImageView;
        TextView titleTextView;
        TextView contentTextView;
        ImageView contentImageView;
        TextView contentAreaTextView;
        TextView contentIntroductionTextView;
    }
}
