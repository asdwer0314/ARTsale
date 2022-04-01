package ru.sfedu.model;


import com.opencsv.bean.CsvBindByPosition;
import ru.sfedu.model.enums.ProductType;

import java.util.Objects;

/**
 * Class Product
 */
public class Product {


  @CsvBindByPosition(position = 0)
  protected long id;

  @CsvBindByPosition(position = 1)
  protected String name;

  @CsvBindByPosition(position = 2)
  protected int price;

  @CsvBindByPosition(position = 3)
  private int useTime;

  @CsvBindByPosition(position = 4)
  private String description;

  @CsvBindByPosition(position = 5)
  protected ProductType prType;


  /**
   * Instantiates a new Product.
   */
  public Product() {
  }

  /**
   * new Product
   *
   * @param id          the id
   * @param name        the name
   * @param price       the price
   * @param useTime     the use time
   * @param description the description
   * @param prType       the product type
   */
  public Product(long id,
                 String name,
                 int price,
                 int useTime,
                 String description,
                 ProductType prType) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.useTime = useTime;
    this.description = description;
    this.prType = prType;
  }

  /**
   * Get id
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Set id
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Get name
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set name
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get price
   * @return the price
   */
  public int getPrice() {
    return price;
  }

  /**
   * Set price
   * @param price the price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Get useTime
   * @return the use time
   */
  public int getUseTime() {
    return useTime;
  }

  /**
   * Set useTime
   * @param useTime the useTime
   */
  public void setUseTime(int useTime) {
    this.useTime = useTime;
  }

  /**
   * Get description
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set description
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get prType
   * @return the prType
   */
  public ProductType getprType() {
    return prType;
  }

  /**
   * Set prType
   * @param prType the prType
   */
  public void setPrType(ProductType prType) {
    this.prType = prType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return getId() == product.getId()
            && getPrice() == product.getPrice()
            && getUseTime() == product.getUseTime()
            && getName().equals(product.getName())
            && getDescription().equals(product.getDescription())
            && getprType() == product.getprType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPrice(), getUseTime(), getDescription(), getprType());
  }
}
