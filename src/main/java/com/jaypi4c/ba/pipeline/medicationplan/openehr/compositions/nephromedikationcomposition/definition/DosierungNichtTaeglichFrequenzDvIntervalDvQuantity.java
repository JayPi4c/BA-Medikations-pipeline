package com.jaypi4c.ba.pipeline.medicationplan.openehr.compositions.nephromedikationcomposition.definition;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2023-09-13T13:58:55.864079677+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.29.0"
)
@OptionFor("DV_INTERVAL<DV_QUANTITY>")
public class DosierungNichtTaeglichFrequenzDvIntervalDvQuantity implements RMEntity, DosierungNichtTaeglichFrequenzChoice {
  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/upper
   */
  @Path("/upper|magnitude")
  private Double upperMagnitude;

  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/upper
   */
  @Path("/upper|units")
  private String upperUnits;

  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/lower
   */
  @Path("/lower|magnitude")
  private Double lowerMagnitude;

  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/lower
   */
  @Path("/lower|units")
  private String lowerUnits;

  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/lower_included
   */
  @Path("/lower_included")
  private Boolean lowerIncluded;

  /**
   * Path: Medikamentenliste/Verordnung von Arzneimittel/Verordnung/Therapeutische Anweisung/Dosierung - nicht täglich/Frequenz/upper_included
   */
  @Path("/upper_included")
  private Boolean upperIncluded;

  public void setUpperMagnitude(Double upperMagnitude) {
     this.upperMagnitude = upperMagnitude;
  }

  public Double getUpperMagnitude() {
     return this.upperMagnitude ;
  }

  public void setUpperUnits(String upperUnits) {
     this.upperUnits = upperUnits;
  }

  public String getUpperUnits() {
     return this.upperUnits ;
  }

  public void setLowerMagnitude(Double lowerMagnitude) {
     this.lowerMagnitude = lowerMagnitude;
  }

  public Double getLowerMagnitude() {
     return this.lowerMagnitude ;
  }

  public void setLowerUnits(String lowerUnits) {
     this.lowerUnits = lowerUnits;
  }

  public String getLowerUnits() {
     return this.lowerUnits ;
  }

  public void setLowerIncluded(Boolean lowerIncluded) {
     this.lowerIncluded = lowerIncluded;
  }

  public Boolean isLowerIncluded() {
     return this.lowerIncluded ;
  }

  public void setUpperIncluded(Boolean upperIncluded) {
     this.upperIncluded = upperIncluded;
  }

  public Boolean isUpperIncluded() {
     return this.upperIncluded ;
  }
}