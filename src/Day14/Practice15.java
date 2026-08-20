package Day14;

import java.util.ArrayList;
import java.util.List;

public class Practice15 {
    public static void main(String[] args) {
        // <?>는 어떤 타입이든 다 들어올 수 있는 와일드카드(조커) 타입
        List <InventorySlot<?>> inventory = new ArrayList<>();
        // ? 와일드 카드 타입 사용한 경우
        InventorySlot<String> slot1 = new InventorySlot<>(1, "집행자의 검");
        InventorySlot<Integer> slot2 = new InventorySlot<>(2, 500000);
        InventorySlot<Double> slot3 = new InventorySlot<>(3, 85.5);
        InventorySlot<String> slot4 = new InventorySlot(4, "드래곤 갑옷");

        // ? 와일드카드 타입인 경우 다양한 제네릭 타입 받을 수 있다.
        inventory.add(slot1);
        inventory.add(slot2);
        inventory.add(slot3);
        inventory.add(slot4);

        // System.out.println(inventory.get(3).getSlotNumber());
        // System.out.println(inventory.get(3).getData());

        
        System.out.println("=== 인벤토리 슬롯 목록 ===");
        for(InventorySlot slot : inventory){
            System.out.print("[슬롯 ");
            System.out.print(slot.getSlotNumber());
            System.out.print("번] 보관: ");
            System.out.print(slot.getData());
            System.out.println();
        }
        System.out.println("-------------------------------------------");


        System.out.println("=== 인벤토리 슬롯 목록 ===");
        inventory.forEach((str) -> { System.out.println("[슬롯 "+ str.getSlotNumber() + "번] 보관: " + str.getData()); });
        System.out.println("-------------------------------------------");
    }
}

class InventorySlot < T > {
    private int slotNumber;
    private T data;

    InventorySlot(){}

    public InventorySlot(int slotNumber, T data) {
        this.slotNumber = slotNumber;
        this.data = data;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    
}

/*-------------------------------------------
[ Practice15 ] 컬렉션 기반 인벤토리 슬롯 관리 시스템
상황: 
게임 인벤토리는 여러 개의 제네릭 슬롯(InventorySlot<T>)으로 구성되며, 
전체 슬롯 목록은 List 컬렉션을 통해 일괄 관리 및 순회 출력을 수행합니다.

요구사항:
1. InventorySlot<T> 제네릭 클래스 작성:
   - 필드: private int slotNumber, private T data
2. Main 실행 클래스 구현:
   - 다음 슬롯 객체들을 리스트에 추가:
     * 슬롯 1번: 문자열 무기 ("집행자의 검")
     * 슬롯 2번: 정수형 골드 (500000)
     * 슬롯 3번: 실수형 강화 확률 (85.5)
     * 슬롯 4번: 문자열 방어구 ("드래곤 갑옷")
   - 향상된 for문(for-each)을 사용하여 모든 슬롯 정보를 순회 출력

출력 예시:
=== 인벤토리 슬롯 목록 ===
[슬롯 1번] 보관: 집행자의 검
[슬롯 2번] 보관: 500000
[슬롯 3번] 보관: 85.5
[슬롯 4번] 보관: 드래곤 갑옷
-------------------------------------------*/