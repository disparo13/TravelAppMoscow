package su.mikheev.alex.travelappmoscow;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MonumentsFragment extends Fragment {
    public MonumentsFragment() {
        // Required empty public constructor
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);
        Context context = getActivity();
        final ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item(context.getResources().getStringArray(R.array.vysotsky_array)));
        items.add(new Item(context.getResources().getStringArray(R.array.nikulin_array)));
        items.add(new Item(context.getResources().getStringArray(R.array.gagarin_array)));
        items.add(new Item(context.getResources().getStringArray(R.array.zhukov_array)));
        items.add(new Item(context.getResources().getStringArray(R.array.okudzhava_array)));

        // Create an {@link ItemAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list
        ItemAdapter adapter =
                new ItemAdapter(getActivity(), items, R.color.category_monuments);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}
