package domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Embeddable
public class Address implements Serializable {
    @Size(min = 4, max = 6)
    private String zipCode;
    private String city;
    private String streetName;
    private String buildingNo;
    private String appNo;
    @Enumerated(EnumType.STRING)
    private AddressType type;

    public Address() {
    }

    public Address(String zipCode, String city, String streetName, AddressType type, String buildingNo, String appNo) {
        this.zipCode = zipCode;
        this.city = city;
        this.streetName = streetName;
        this.type = type;
        this.buildingNo = buildingNo;
        this.appNo = appNo;
    }

    @Override
    public String toString() {
        return "\nAddress{" +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", type='" + type + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", appNo='" + appNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null)
            return false;
        if (streetName != null ? !streetName.equals(address.streetName) : address.streetName != null)
            return false;
        if (type != null ? !type.equals(address.type) : address.type != null)
            return false;
        if (buildingNo != null ? !buildingNo.equals(address.buildingNo) : address.buildingNo != null)
            return false;
        return appNo != null ? appNo.equals(address.appNo) : address.appNo == null;

    }

    @Override
    public int hashCode() {
        int result = zipCode != null ? zipCode.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (buildingNo != null ? buildingNo.hashCode() : 0);
        result = 31 * result + (appNo != null ? appNo.hashCode() : 0);
        return result;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
