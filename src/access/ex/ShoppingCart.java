package access.ex;

public class ShoppingCart {
    private  Item[] items = new Item[10];
    private int itemCount;
    private int totalPrice;

    public void addItem(Item item){
        if(itemCount >= items.length){
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }

        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems(){
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            items[i].showItemInfo();
            totalPrice += items[i].getAmount();
        }
        System.out.println("전체 가격 합: " + totalPrice);
    }
}
