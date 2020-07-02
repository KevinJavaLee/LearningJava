package com.kevin.day13.pattern;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-17:00
 */

//代理类
public interface Network {
    public void brower();
}

class  RealServer implements Network{
    @Override
    public void brower() {
        System.out.println("这是真正的服务器");
    }
}

class ProxyServer implements Network{

    private Network network ;

    ProxyServer(Network network){
        this.network = network;
    }

    public void check() {
        System.out.println("检查连接是否正常！");
    }
    @Override
    public void brower() {
        check();
        network.brower();
    }
}

class ProxyServerTest{
    public static void main(String[] args) {
        Network network = new ProxyServer(new RealServer());
        network.brower();

    }
}


