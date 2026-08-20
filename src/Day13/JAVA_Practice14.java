package Day13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JAVA_Practice14 {
    public static void main(String[] args) {

        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
        Scanner scan = new Scanner(System.in, "EUC-KR");

        while (true) {
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            int ch = scan.nextInt();
            if (ch == 1) {
                System.out.print("찾고 있는 차량의 번호를 입력: ");     String carNum = scan.next();
                findCarLocation(carParkingList, carNum);

            } // 위치찾기 구현

            if (ch == 2) {
                System.out.print("입차하려는 구역을 입력하세요: ");     String location = scan.next();
                System.out.print("차량 번호를 입력하세요: ");           String carNumber = scan.next();
                String addList = addNewCar(carParkingList, location, carNumber);
                carParkingList = carParkingList.concat(addList);
                // System.out.println(carParkingList);
            } // 입차 구현

            if (ch == 3) {
                System.out.print("출차하려는 차량의 번호를 입력하세요: ");  String carNum = scan.next();
                String deleteResult = deleteCar(carParkingList, carNum);

                if (!deleteResult.equals("")) {
                    String[] carArr = carParkingList.split("\n");
                    StringBuilder sb = new StringBuilder();
                    for(String car : carArr){
                        if (car.equals(deleteResult)) continue; // 삭제 대상만 건너뜀
                        if (sb.length() > 0) sb.append("\n");
                        sb.append(car);
                    }
                    carParkingList = sb.toString();
                    // System.out.println(carParkingList);
                }
            } // 출차 구현

            /* 
            * ③ 출차 처리
            * 기능: 출차할 차량 번호를 입력받아 해당 차량의 행을 carParkingList에서 삭제합니다.
            * 입력: carNumber (출차할 차량번호)
            * 반환: 해당 차량이 제거되고 줄바꿈이 올바르게 정리된 갱신된 carParkingList 문자열
            * 기본 정책: 최초 30분 무료추가 요금: 30분 초과 시, 10분당 1,000원 (10분 단위 절상/올림 계산)
            * 예: 31분 ~ 40분 주차 -> 1,000원
            * 예: 41분 ~ 50분 주차 -> 2,000원
            * 일일 최대 요금: 24시간(1일)당 최대 20,000원여러 날에 걸쳐 주차한 경우,
            * 각 일자 단위로 계산 후 합산하거나 총 일수×20,000원 + 잔여시간 요금(최대 20,000원)을 적용합니다.
            * 
            */
        }
    }

    static void findCarLocation(String carParkingList, String carNum){
        String[] carArr = carParkingList.split("\n");
        boolean result = false;
        for(String car : carArr){
            char location = car.charAt(0);

            if (car.indexOf(carNum) != -1) {
                System.out.println("해당 차량의 위치: " + location);
                result = true;
                break;
            }
        }

        if (!result) {
            System.out.println("미등록 차량입니다.");
        }
    }

    static String addNewCar(String carParkingList, String newLocation, String carNumber){
        String[] carArr = carParkingList.split("\n");
        boolean result = true;
        String resultList = "";
        
        for(String car : carArr){
            char location = car.charAt(0);
            String strloc = location+"";
            if (newLocation.equals(strloc)) {
                System.out.println("이미 주차중인 구역입니다.");
                result = false;
                break;
            }
        }

        if (result) {
            StringBuilder resultBuilder = new StringBuilder();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            String newDay = localDateTime.format(formatter); 

            resultBuilder.append("\n");                     // [1] 구분번호 기입
            resultBuilder.append(newLocation+",");              // [2] 주차구역 기입
            resultBuilder.append(carNumber+",");                // [3] 차량번호 기입
            resultBuilder.append(newDay);                       // [4] 특정 형식으로 입차시간 기입

            String newCarString = resultBuilder.toString();     // 빌더를 스트링으로 변환
            // System.out.println(newCarString);

            resultList = newCarString;                          // 결과 문자열에 담기
            //System.out.println(resultList);

            System.out.printf("입차가 성공적으로 완료되었습니다, 입차 위치: %s\n", newLocation);
        }

        return resultList; // 추가할 문자열 부분을 반환함
    }

    static String deleteCar(String carParkingList, String carNum){
        if (carParkingList.equals("")) {
            return "";
        }
        int finalfee = 0;
        String resultList = "";
        String deleteNow = "";
        
        // 문자열 줄바꿈 기준으로 분리
        String[] carArr = carParkingList.split("\n");

        // 분리된 배열 순회(없앨 부분 찾고, 시간 계산하기)
        for(String car : carArr){
            String[] carInfo = car.split(","); // 차량정보를 분리{주차구역, 차량번호, 입차시간}
            if (carInfo[1].equals(carNum)) { // 번호를 찾으면? (반환값이 -1이 아니면)
                deleteNow = car; // 문자열에서 없애버릴 부분(출차할 차량정보 전체)을 지정
            
                int year = Integer.parseInt(carInfo[2].substring(0, 4));
                int month = Integer.parseInt(carInfo[2].substring(4, 6));
                int day = Integer.parseInt(carInfo[2].substring(6, 8));
                int hour = Integer.parseInt(carInfo[2].substring(8, 10));
                int min = Integer.parseInt(carInfo[2].substring(10, 12));
                // System.out.println( year );
                // System.out.println( month );
                // System.out.println( day );
                // System.out.println( hour );
                // System.out.println( min );

                LocalDateTime inTime = LocalDateTime.of(year, month, day, hour, min); // 입차 시각

                LocalDateTime nowTime = LocalDateTime.now(); // 현재 시각

                // 단순 일(Day) 차이 기준으로 주차일 구하기
                // .getYear = 연도를 int 형태로 반환, .getDayOfYear() = 해당 연도의 몇 번째 날인지(1~366, int) 반환
                int inTotalDays = (inTime.getYear() * 365) + inTime.getDayOfYear();
                int nowTotalDays = (nowTime.getYear() * 365) + nowTime.getDayOfYear();
                int diffDays = nowTotalDays - inTotalDays; // 입차일시(과거) - 현재 = 이용일

                // 분(min) 차이 기준
                int inMinutesOfDay = (inTime.getHour() * 60) + inTime.getMinute();
                int nowMinutesOfDay = (nowTime.getHour() * 60) + nowTime.getMinute();

                // 차이난 일수, 분과 분 차이 합계           //현재 분 - 과거 분 = 이용한 분(minute)
                int totalMinutes = (diffDays * 24 * 60) + (nowMinutesOfDay - inMinutesOfDay);
                if (totalMinutes < 0) {
                    totalMinutes = 0; // 음수 방지
                }

                int days = totalMinutes / (24 * 60); // 주차일수(몫)
                int remainMinutes = totalMinutes % (24 * 60); // 주차일수(몫) 제외한 나머지
                int remainFee = 0;
                if (remainMinutes > 30) {
                    int billableMinutes = remainMinutes - 30;
                    remainFee = ((billableMinutes + 9) / 10) * 1000; // 31 - 30 = 1분만 더 쓰더라도 1000원 더 내라
                }
                if (remainFee > 20000) {
                    remainFee = 20000; // 일 최대 20,000원 캡
                }
                int totalFee = (days * 20000) + remainFee; // 일별 추가 요금


                //결과 출력하기
                System.out.println("====== 출차 안내 ======");
                System.out.println("차량번호: " + carNum);
                System.out.println("입차시간: " + inTime); // LocalDateTime.toString() 형태 출력
                System.out.println("출차시간: " + nowTime); // LocalDateTime.toString() 형태 출력
                System.out.println("주차시간: " + totalMinutes + "분 (" + days + "일 " + remainMinutes + "분)");
                System.out.println("주차요금: " + totalFee + "원");
                System.out.println("=====================");
                break; // 다 했으면 반복문 탈출
            }
        }

        // 반복문 종료 후, 삭제할 부분이 없는 것으로 판별되면?
        if (deleteNow.equals("")) {
            System.out.println("출차할 차량이 없습니다.");
            return "";
        }

        return deleteNow;
    }
}


/*
 * [ 문자열 실습 ] 타워 주차 관리 시스템 데이터 처리
 * 1. 문제 개요
 * 주차장 관제 시스템에서 관리 중인 차량 데이터(carParkingList)는 단일 String으로 관리되고 있습니다.
 * 이 데이터를 기반으로 입차, 출차, 내 차량 위치 찾기 기능을 구현하세요.
 * 단) 새로운 클래스 만들지 않습니다.
 * 
 * 2. 데이터 규격
 * 데이터 구분자:
 * 행(객체/차량) 구분: 줄바꿈 문자 (\n)
 * 열(속성) 구분: 쉼표 (,)
 * 컬럼 순서: 위치번호,차량번호,날짜시간(YYYYMMDDhhmm)
 * 
 * 초기 데이터 예시:
 * String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
 * 
 * 3. 구현 요구사항
 * 다음 세 기능 구현하세요.
 * ① 차량 위치 찾기 (findCarLocation)
 * 기능: 차량 번호를 입력받아 현재 주차된 위치 번호를 반환합니다.
 * 입력: carNumber (찾을 차량번호)
 * 출력/반환:
 * 차량이 존재할 경우: 주차 위치 번호 (예: "3")
 * 차량이 없을 경우: "미등록 차량" 또는 -1 반환
 * 
 * ② 입차 처리
 * 기능: 새로운 차량의 주차 정보를 기존 데이터에 추가합니다.
 * 조건:
 * 이미 주차되어 있는 위치 번호에는 중복 주차할 수 없습니다
 * 입력: location (위치번호), carNumber (차량번호), dateTime (2입차일시)
 * 출력/반환:
 * 차량이 입차한 경우 : 주차 위치 번호 (예: "3")
 * 차량이 입차가 없을 경우: 위치 번호에는 중복 주차할 수 없습니다. (위치 중복 시 입차 불가 메시지 출력)
 * 
 * ③ 출차 처리
 * 기능: 출차할 차량 번호를 입력받아 해당 차량의 행을 carParkingList에서 삭제합니다.
 * 입력: carNumber (출차할 차량번호)
 * 반환: 해당 차량이 제거되고 줄바꿈이 올바르게 정리된 갱신된 carParkingList 문자열
 * 기본 정책: 최초 30분 무료추가 요금: 30분 초과 시, 10분당 1,000원 (10분 단위 절상/올림 계산)
 * 예: 31분 ~ 40분 주차 -> 1,000원
 * 예: 41분 ~ 50분 주차 -> 2,000원
 * 일일 최대 요금: 24시간(1일)당 최대 20,000원여러 날에 걸쳐 주차한 경우,
 * 각 일자 단위로 계산 후 합산하거나 총 일수×20,000원 + 잔여시간 요금(최대 20,000원)을 적용합니다.
 * 
 */