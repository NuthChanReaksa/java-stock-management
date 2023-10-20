package Stock;

public class Stock{
    private int id;
    private String name;
    private int unitPrice;
    private int qty;
    private String importDate;
    public Stock(){}
    public Stock(int id, String name,int unitPrice, int qty, String importDate){
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.importDate = importDate;
    }



    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setUnitPrice(int unitPrice){
        this.unitPrice = unitPrice;
    }
    public int getUnitPrice(){
        return unitPrice;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public int getQty(){
        return qty;
    }
    public void setImportDate(String importDate){
        this.importDate = importDate;
    }
    public String getImportDate(){
        return importDate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                ", importDate='" + importDate + '\'' +
                '}';
    }
}