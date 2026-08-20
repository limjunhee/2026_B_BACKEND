String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227\n";
        
        // [Scanner(InputStream)] 표준 입력 스트림(System.in)으로부터 데이터를 읽어오기 위한 Scanner 객체 생성
        Scanner scan = new Scanner(System.in);

        while (true) {
            // [PrintStream.print(String)] 콘솔에 문자열을 줄바꿈 없이 출력
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            
            // [Scanner.nextInt()] 입력된 토큰을 int 타입 정수로 읽어와 반환
            int ch = scan.nextInt();
            
            // [String.split(String regex)] 지정한 정규표현식(줄바꿈 기준)에 맞춰 문자열을 분할하여 String 배열로 반환
            String[] carList = carParkingList.split("\n"); // 여러개 차 정보들을 각각 배열 요소로 저장하기
            
            if( ch == 1 ){ 
                // [Scanner.next()] 공백(스페이스, 줄바꿈 등) 전까지의 다음 문자열 토큰을 읽어와 반환
                String findCar = scan.next();
                for( String car : carList ){
                    // [String.equals(Object)] 두 문자열의 내용이 일치하는지 비교하여 boolean 값 반환
                    if( car.equals( "" ) ) break;
                    
                    // [String.split(String regex)] 쉼표(,)를 기준으로 문자열을 분할하여 String 배열로 반환
                    String[] info = car.split(",");
                    
                    // [String.equals(Object)] 차량번호 일치 여부 비교
                    if( info[1].equals( findCar ) ){
                        // [PrintStream.println(String)] 콘솔에 문자열을 출력하고 줄바꿈 수행
                        System.out.println( info[0] );
                        break;
                    } 
                }
            } // 위치찾기 구현 
            
            if( ch == 2 ){ 
                // [Scanner.nextInt()] 주차 위치 번호를 int 타입으로 입력받음
                int location = scan.nextInt();
                
                // [Scanner.next()] 차량번호 문자열을 입력받음
                String carNumber = scan.next();
                
                // [Scanner.next()] 입차일시 문자열을 입력받음
                String dateTime = scan.next();
                boolean find = false;
                
                for( String car : carList ){
                    // [String.equals(Object)] 빈 문자열 여부 확인
                    if( car.equals( "" ) ) break;
                    
                    // [String.split(String regex)] 쉼표(,) 기준으로 파싱
                    String[] info = car.split(",");
                    
                    // [String.equals(Object)] 자리 중복 여부 확인
                    if( info[0].equals( carNumber ) ){
                        // [PrintStream.println(String)] 중복 안내 메시지 출력 및 줄바꿈
                        System.out.println("이미 주차된 자리 ");
                        find = true;
                        break;
                    } 
                }
                if( find == false ){
                    // [StringBuilder()] 가변(mutable) 문자열 생성을 위한 StringBuilder 인스턴스 생성
                    StringBuilder builder = new StringBuilder();
                    
                    // [StringBuilder.append(int / String)] 문자열 버퍼 끝에 전달된 데이터(정수/문자열)를 덧붙임
                    builder.append(location);       builder.append(",");
                    builder.append(carNumber);      builder.append(",");
                    builder.append(dateTime);       builder.append(",");
                    builder.append("\n");
                    
                    // 문자열 결합 시 내부적으로 builder.toString()이 호출되어 String으로 변환 후 결합
                    carParkingList += builder;
                }
            } // 입차 구현 
            
            if( ch == 3 ){ 
                // [Scanner.next()] 출차할 차량번호 문자열 입력받음
                String carNumber = scan.next();
                for( String car : carList ){
                    // [String.equals(Object)] 빈 문자열 여부 확인
                    if( car.equals( "" ) ) break;
                    
                    // [String.split(String regex)] 쉼표(,) 기준으로 파싱
                    String[] info = car.split(",");
                    
                    // [String.equals(Object)] 출차할 차량번호와 일치하는지 비교
                    if( info[1].equals( carNumber ) ){
                        // [String.substring(int beginIndex, int endIndex)] 시작 위치부터 끝 위치 전까지의 부분 문자열 추출
                        // [Integer.parseInt(String s)] 숫자 형식의 문자열을 기본형 정수(int)로 파싱하여 반환
                        int year = Integer.parseInt( info[2].substring( 0 , 4 ) );      
                        int month = Integer.parseInt( info[2].substring( 4 , 6 ));     
                        int day = Integer.parseInt( info[2].substring( 6 , 8 ));       
                        int hur = Integer.parseInt( info[2].substring( 8 , 10 ));      
                        int min = Integer.parseInt( info[2].substring( 10 , 12 ));      
                        
                        // [LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute)] 지정된 연, 월, 일, 시, 분으로 LocalDateTime 객체 생성
                        LocalDateTime inTime = LocalDateTime.of(year, month, day, hur, min ); // 주차시간 
                        
                        // [LocalDateTime.now()] 시스템의 현재 날짜와 시간 정보를 가진 LocalDateTime 객체 반환
                        LocalDateTime now = LocalDateTime.now(); // 현재시간
                        
                        // 연/월이 같은 단순 일자 차이 기준
                        // [LocalDateTime.getYear()] 연도(int) 반환
                        // [LocalDateTime.getDayOfYear()] 해당 연도의 몇 번째 날인지(1~366, int) 반환
                        int inTotalDays = (inTime.getYear() * 365) + inTime.getDayOfYear();
                        int nowTotalDays = (now.getYear() * 365) + now.getDayOfYear();
                        int diffDays = nowTotalDays - inTotalDays;
                        
                        // 분 차이 기준
                        // [LocalDateTime.getHour()] 시간(0~23, int) 반환
                        // [LocalDateTime.getMinute()] 분(0~59, int) 반환
                        int inMinutesOfDay = (inTime.getHour() * 60) + inTime.getMinute();
                        int nowMinutesOfDay = (now.getHour() * 60) + now.getMinute();
                        
                        // 차이난 일수의 분과 분 차이 합계
                        int totalMinutes = (diffDays * 24 * 60) + (nowMinutesOfDay - inMinutesOfDay);
                        if( totalMinutes < 0 ) totalMinutes = 0;
                        
                        // 3. 요금 계산 (일자 단위 + 잔여 분)
                        int days = totalMinutes / (24 * 60);          // 일수
                        int remainMinutes = totalMinutes % (24 * 60); // 일수 제외한 분(나머지)
                        int remainFee = 0;
                        if (remainMinutes > 30) {
                            int billableMinutes = remainMinutes - 30;
                            remainFee = ((billableMinutes + 9) / 10) * 1000; // 10분 단위 올림
                        }
                        if (remainFee > 20000) {
                            remainFee = 20000; // 일 최대 20,000원 캡
                        }
                        int totalFee = (days * 20000) + remainFee; // 일별 추가 요금.
                        
                        // [PrintStream.println(String / Object)] 각 출력 라인별 정보 출력 및 줄바꿈
                        System.out.println("====== 출차 안내 ======");
                        System.out.println("차량번호: " + carNumber);
                        System.out.println("입차시간: " + inTime); // LocalDateTime.toString() 형태 출력
                        System.out.println("출차시간: " + now);    // LocalDateTime.toString() 형태 출력
                        System.out.println("주차시간: " + totalMinutes + "분 (" + days + "일 " + remainMinutes + "분)");
                        System.out.println("주차요금: " + totalFee + "원");
                        System.out.println("=====================");
                        
                        // 차량정보 제거
                        // [String.replace(CharSequence target, CharSequence replacement)] 대상 문자열 내의 일치하는 모든 하위 문자열을 치환(여기서는 제거)하여 새로운 String 반환
                        carParkingList = carParkingList.replace( info[0]+","+info[1]+","+info[2]+"\n", "");

                        break;
                    } 
                }
            } // 출차 구현
        }