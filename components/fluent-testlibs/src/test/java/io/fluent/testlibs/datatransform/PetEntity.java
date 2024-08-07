package io.fluent.testlibs.datatransform;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class PetEntity {
  private int id;
  private String name;
  private boolean isPopular;
  private String status;
  private String category;
  private Date createDate;
  private List<String> tags;

  // getter/setter

}
