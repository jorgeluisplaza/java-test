package muranatest.com.murana.userregistration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    // private String cityCode;
    // private String countryCode;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // public String getCityCode() {
    //     return cityCode;
    // }

    // public void setCityCode(String cityCode) {
    //     this.cityCode = cityCode;
    // }

    // public String getCountryCode() {
    //     return countryCode;
    // }

    // public void setCountryCode(String countryCode) {
    //     this.countryCode = countryCode;
    // }
}
