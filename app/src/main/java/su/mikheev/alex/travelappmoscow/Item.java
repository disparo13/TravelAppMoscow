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
     * @param itemName         - a name for the item in catalogue
     * @param itemAddress      - a street address for the item
     * @param itemWorkingHours - described working hours for the item
     */
    public Item(String itemName, String itemAddress, String itemWorkingHours) {
        mItemName = itemName;
        mItemAddress = itemAddress;
        mItemWorkingHours = itemWorkingHours;
    }

    /**
     * @param itemName         - a name for the item in catalogue
     * @param itemAddress      - a street address for the item
     * @param itemWorkingHours - described working hours for the item
     * @param imageResourceId  - image resource ID for the item
     */
    public Item(String itemName, String itemAddress, String itemWorkingHours,
                int imageResourceId) {
        mItemName = itemName;
        mItemAddress = itemAddress;
        mItemWorkingHours = itemWorkingHours;
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
