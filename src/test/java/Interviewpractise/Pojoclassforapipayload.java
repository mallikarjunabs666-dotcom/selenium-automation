package Interviewpractise;

public class Pojoclassforapipayload {

    String firstname;
    String lastname;
    int totalprice;
    Boolean depositpaid;
    Bookingdatespojoclass bookingdates;;
    String additionalneeds;

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname=firstname;
    }


    public String getLastname()

    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname=lastname;
    }


    public int gettotalprice()
    {
        return totalprice;
    }

    public void settotalprice(int totalprice)
    {
        this.totalprice=totalprice;
    }

    public Boolean getdepositpaid()
    {
        return true;
    }

    public void setdepositpaid(Boolean depositpaid)
    {
        this.depositpaid=depositpaid;
    }


    public String getAdditionalneeds()
    {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds)
    {
        this.additionalneeds=additionalneeds;
    }


    public Bookingdatespojoclass getbookingdates()
    {
        return bookingdates;
    }

    public void setbookingdates(Bookingdatespojoclass bookingdates)
    {
        this.bookingdates=bookingdates;
    }

}
