//import java.util.Random;
//import java.util.Vector;
//
//public class Ant implements Cloneable {
//    private Vector<Integer> tabu; //禁忌表
//    private Vector<Integer> allowedCities; //允许搜索的城市
//    private float[][] delta; //信息数变化矩阵
//    private int[][] distance; //距离矩阵
//
//    private float alpha;
//    private float beta;
//    private int tourLength; //路径长度
//    private int cityNum; //城市数量
//    private int firstCity; //起始城市
//    private int currentCity; //当前城市
//    public Ant(){
//        cityNum = 30;
//        tourLength = 0;
//    }
//    public Ant(int num){
//        cityNum = num;
//        tourLength = 0;
//    }
//     public void init(int[][] distance, float a, float b){
//            48:     alpha = a;
//            49:     beta = b;
//            50:     allowedCities = new Vector<Integer>();
//            51:     tabu = new Vector<Integer>();
//            52:     this.distance = distance;
//            53:     delta = new float[cityNum][cityNum];
//            54:     for (int i = 0; i < cityNum; i++) {
//                55:       Integer integer = new Integer(i);
//                56:       allowedCities.add(integer);
//                57:       for (int j = 0; j < cityNum; j++) {
//                    58:         delta[i][j] = 0.f;
//                    59:       }
//                60:     }
//            61:
//            62:     Random random = new Random(System.currentTimeMillis());
//            63:     firstCity = random.nextInt(cityNum);
//            64:     for (Integer i:allowedCities) {
//                65:       if (i.intValue() == firstCity) {
//                    66:         allowedCities.remove(i);
//                    67:         break;
//                    68:       }
//                69:     }
//            70:
//            71:     tabu.add(Integer.valueOf(firstCity));
//            72:     currentCity = firstCity;
//            73:   }
// 74:
//         75:   /**
//  76:    * 选择下一个城市
//  77:    * @param pheromone 信息素矩阵
//  78:    */
//         79:   public void selectNextCity(float[][] pheromone){
//            80:     float[] p = new float[cityNum];
//            81:     float sum = 0.0f;
//            82:     //计算分母部分
//            83:     for (Integer i:allowedCities) {
//                84:       sum += Math.pow(pheromone[currentCity][i.intValue()], alpha)*Math.pow(1.0/distance[currentCity][i.intValue()], beta);
//                85:     }
//            86:     //计算概率矩阵
//            87:     for (int i = 0; i < cityNum; i++) {
//                88:       boolean flag = false;
//                89:       for (Integer j:allowedCities) {
//                    90:
//                    91:         if (i == j.intValue()) {
//                        92:           p[i] = (float) (Math.pow(pheromone[currentCity][i], alpha)*Math.pow(1.0/distance[currentCity][i], beta))/sum;
//                        93:           flag = true;
//                        94:           break;
//                        95:         }
//                    96:       }
//                97:
//                98:       if (flag == false) {
//                    99:         p[i] = 0.f;
//                    100:       }
//                101:     }
//            102:
//            103:     //轮盘赌选择下一个城市
//            104:     Random random = new Random(System.currentTimeMillis());
//            105:     float sleectP = random.nextFloat();
//            106:     int selectCity = 0;
//            107:     float sum1 = 0.f;
//            108:     for (int i = 0; i < cityNum; i++) {
//                109:       sum1 += p[i];
//                110:       if (sum1 >= sleectP) {
//                    111:         selectCity = i;
//                    112:         break;
//                    113:       }
//                114:     }
//            115:
//            116:     //从允许选择的城市中去除select city
//            117:     for (Integer i:allowedCities) {
//                118:       if (i.intValue() == selectCity) {
//                    119:         allowedCities.remove(i);
//                    120:         break;
//                    121:       }
//                122:     }
//            123:     //在禁忌表中添加select city
//            124:     tabu.add(Integer.valueOf(selectCity));
//            125:     //将当前城市改为选择的城市
//            126:     currentCity = selectCity;
//            127:
//            128:   }
//129:
//        130:   /**
// 131:    * 计算路径长度
// 132:    * @return 路径长度
// 133:    */
//        134:   private int calculateTourLength(){
//            135:     int len = 0;
//            136:     for (int i = 0; i < cityNum; i++) {
//                137:       len += distance[this.tabu.get(i).intValue()][this.tabu.get(i+1).intValue()];
//                138:     }
//            139:     return len;
//            140:   }
//}
