package com.guedes.parser.output;

import com.guedes.parser.entity.Entity;
import java.util.List;

public class SalesReportOutput {
  private final List<? extends Entity> entities;

  public SalesReportOutput(List<? extends Entity> entities) {
    this.entities = entities;
  }

  public List<? extends Entity> getEntities() {
    return this.entities;
  }
}
