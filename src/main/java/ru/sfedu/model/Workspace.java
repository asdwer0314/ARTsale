package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import ru.sfedu.model.enums.ProductType;
import ru.sfedu.model.enums.WorkSpaceType;

import java.util.Objects;

import static ru.sfedu.Constants.DEFAULT_CONFIG_PATH;

/**
 *  Workspaces
 */

@Root(name="Workspace")
public class Workspace extends Product {

  @CsvBindByPosition(position = 6)
  private WorkSpaceType type;

  /**
   * Instantiates a new Workspace
   */
  public Workspace() {
  }

  /**
   * new Workspace
   *
   * @param id          the id
   * @param name        the name
   * @param price       the price
   * @param useTime     the use time
   * @param description the description
   * @param type        the type
   */
  public Workspace(long id,
                   String name,
                   int price,
                   int useTime,
                   String description,
                   WorkSpaceType type) {
    super(id, name, price, useTime, description, ProductType.WORKSPACE);
    this.type = type;
  }


  /**
  * Get type
  * @return the type
  */
  public WorkSpaceType getType() {
    return type;
  }

  /**
  * Set type
  * @param type the type
  */
  public void setType(WorkSpaceType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Workspace)) return false;
    Workspace workspace = (Workspace) o;
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
