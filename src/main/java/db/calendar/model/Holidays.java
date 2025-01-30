package db.calendar.model;

import java.util.List;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Holidays {
   public String date;
   public String localName;
   public String name;
   public String countryCode;
   public Boolean fixed;
   public Boolean global;
   @Nullable
   public String counties;
   @Nullable
   public String launchYear;
   public List<String> types;
}
