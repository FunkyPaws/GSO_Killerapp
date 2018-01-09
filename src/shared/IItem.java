package shared;

/**
 * Interface is serializable.
 * Methode getName gets the name of the item.
 * The methode returns a string.
 * Methode getPrice gets the price of the item.
 * The methode reurns a double.
 * Methode getDescription gets the description of the item.
 * The methode retuns a string.
 * Methode getCategory get the category of the item.
 * The methode returns a ItemCategorie Enum.
 */
public interface IItem  {
    String getName();
    Double getPrice();
}
