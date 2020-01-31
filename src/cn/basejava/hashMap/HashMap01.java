package cn.basejava.hashMap;
/*
   手工实现map-01
 */

public class HashMap01 {
    Node2[] table;//位桶数组
    int size;//存放的键值对个数

    //构造函数
    public HashMap01(){
        table = new Node2[16];//初始化位桶数组容量为16（一般为2的整数次幂），在该数组size内进行散列存放
    }

    //put方法实现
    public void put(Object key,Object value){
        Node2 node2 = new Node2();
        node2.hash = myHash(key.hashCode(),table.length);
        node2.key = key;
        node2.value = value;
        node2.next = null;

        Node2 temp = table[node2.hash];
        //定义最后一个节点
        Node2 iterLast = null;
        //定义标志位
        boolean keyRepeat = false;
        if(temp == null){
            table[node2.hash] = node2;
        }else{
            //如果数组下标对应节点不为空：遍历该下标内所有节点进行比较，
            // 如果key相等，进行value覆盖，否则追加到最后一个的next
            while(temp != null){
                if(key.equals(temp.key)){
                    keyRepeat = true;
                    temp.value = value;
                    break;
                }else{
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat){
                iterLast.next = node2;
            }
        }
    }

    //自定义Hash方法实现
    public int myHash(int v,int length){
        System.out.println("按位与：" + (v&(length-1)));
        System.out.println("取余：" + (v%(length-1)));
        return v&(length-1);
    }
    //重写toString方法
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for(int i=0;i<table.length;i++){
            Node2 node = table[i];
            while(null != node){
                sb.append(node.key+":"+node.value+",");
                node = node.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }

    //主方法进行测试
    public static void main(String[] args){
        HashMap01 map = new HashMap01();
        map.put(10,"a");
        map.put(20,"b");
        map.put(30,"c");
        map.put(40,"d");
        System.out.println(map.toString());
    }
}
