package su.mikheev.alex.travelappmoscow;

public class Item {
    // Constant variable to indicate that photo for the item is not provided
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * An item name
     */
    private String mItemName;
    /**
     * Street address for the item
     */
    private String mItemAddress;
    /**
     * Opening hours for the item
     */
    private String mItemWorkingHours;
    /**
     * Image resource ID for the item's picture
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * @param itemArray         - an array with item's description, where
     *                          1st element - Name
     *                          2nd element - Address
     *                          3rd element - Working hours
     */
    public Item(String itemArray[]) {
        mItemName = itemArray[0];
        mItemAddress = itemArray[1];
        mItemWorkingHours = itemArray[2];
    }

    /**
     * @param itemArray         - an array with item's description, where
     *                          1st element - Name
     *                          2nd element - Address
     *                          3rd element - Working hours
     * @param imageResourceId  - image resource ID for the item
     */
    public Item(String itemArray[], int imageResourceId) {
        mItemName = itemArray[0];
        mItemAddress = itemArray[1];
        mItemWorkingHours = itemArray[2];
        mImageResourceId = imageResourceId;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getItemAddress() {
        return mItemAddress;
    }

    public String getItemWorkingHours() {
        return mItemWorkingHours;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * @return do we have an image for the item
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
