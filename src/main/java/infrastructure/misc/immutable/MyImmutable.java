package infrastructure.misc.immutable;


import infrastructure.misc.Bike;

public final class MyImmutable {
    private final String str;
    private final Bike bike;

    public MyImmutable(String str, Bike bike) {
        this.str = new String(str);
        this.bike = bike.clone();
    }

    public String getStr() {
        return new String(str);
    }

    public Bike getBike() {
        return bike.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyImmutable that = (MyImmutable) o;

        if (str != null ? !str.equals(that.str) : that.str != null)
            return false;
        return bike != null ? bike.equals(that.bike) : that.bike == null;

    }

    @Override
    public int hashCode() {
        int result = str != null ? str.hashCode() : 0;
        result = 31 * result + (bike != null ? bike.hashCode() : 0);
        return result;
    }

//        @Override
//    public boolean equals(Object obj){
//        if (obj == null || obj.getClass() != getClass()) return false
//        if (this == obj) return true;
//
//        MyImmutable other = (MyImmutable) obj;
//
//        if (str == null ? other.str != null : !str.equals(other.str))
//            return false;
//
//        if(bike == null ? other.bike != null : !bike.equals(other.bike))
//            return false;
//        return true;
//    }
}
