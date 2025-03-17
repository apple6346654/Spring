package hello.core.lifecycle;



public class NetworkClient   {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //시작호출
    public void connect(){
        System.out.println("connect " + url);
    }

    public void call(String message){
        System.out.println("call " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void diconnect() {
        System.out.println("close: " + url);
    }



    public void init() throws Exception { //의존성 주입후 실행하는 거
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");

    }


    public void close() throws Exception {  //빈이 종료될 떄 실행
        System.out.println("NetworkClient.close");
        diconnect();
    }
}
