package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import ru.sfedu.model.enums.MaterialType;
import ru.sfedu.model.enums.ProductType;
import ru.sfedu.model.enums.WorkSpaceType;

import java.util.Objects;

/**
 * Class Material
 */
public class Material extends Product {

  @CsvBindByPosition(position = 6)
  private MaterialType type;



  /**
   * Instantiates a new Workspace
   */
  public Material() {
  }

  /**
   * new Workspace
   *
   * @param id          the id
   * @param name        the name
   * @param price       the price
   * @param useTime     the use time
   * @param description the description
   * @param type       the type
   */
  public Material(long id,
                   String name,
                   int price,
                   int useTime,
                   String description,
                   MaterialType type) {
    super(id, name, price, useTime, description, ProductType.MATERIAL);
    this.type = type;
  }


  /**
   * Get type
   * @return the type
   */
  public MaterialType getType() {
    return type;
  }

  /**
   * Set type
   * @param type the type
   */
  public void setType(MaterialType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Material)) return false;
    Material workspace = (Material) o;
    return type == workspace.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType());
  }

  @Override
  public String toString() {
    return "Workspace{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", pType=" + prType +
            ", type=" + type +
            '}';
  }
}
