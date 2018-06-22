package su.mikheev.alex.travelappmoscow;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    private static final String LOG_TAG = ItemAdapter.class.getSimpleName();
    /**
     * Resource ID for the background colour of the words list
     **/
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param items   A List of words objects to display in a list
     */
    public ItemAdapter(Activity context, ArrayList<Item> items, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    /**
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Item currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view_name
        TextView nameTextView = convertView.findViewById(R.id.miwok_text_view);
        // Get the miwok translation from the current Word object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getItemName());

        // Find the TextView in the list_item.xml layout with the ID default text view
        TextView addressTextView = convertView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        addressTextView.setText(currentWord.getItemAddress());

        //Find the ImageView in the list_item.xml layout with the ID image
        ImageView itemImageView = convertView.findViewById(R.id.image);

        // Checking about image ID, setting view to it and disabling if it's not found
        if (currentWord.hasImage()) {
            // Get the image from the current Word Object
            itemImageView.setImageResource(currentWord.getImageResourceId());
        } else {
            itemImageView.setVisibility(View.GONE);
        }

        // Set theme color for list item
        View listitems = convertView.findViewById(R.id.items_list);
        // Find the color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the color for the listview
        listitems.setBackgroundColor(color);

        return convertView;
    }
}
