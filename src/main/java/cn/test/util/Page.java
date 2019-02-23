package cn.test.util;

public class Page {

    int start;
    int count;
    int total;

    //构造方法
    public Page(int start,int count){
        super();
        this.start = start;
        this.count = count;
    }
    //计算得到尾页
    public int getLast(){
        int last;
        //假设total=50  count=5
        if(total % count == 0)
            //最后一页开头为45
           last = total - count;
        else
            //不整除 最后一页开头为50
            last = total - total % count;

        last = last < 0 ? 0 : last;
        return last;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //是否有上一页 下一页
    public boolean isHasPreviouse(){
        if (start == 0)
            return false;
        return true;
    }
    public boolean isHasNext(){
        if(getLast() == 0)
            return false;
        return true;
    }

    //计算得到总页数
    public int getTotalPage(){
        int totalPage;

        if(total % count == 0)
            totalPage = total / count;
        else
            totalPage = total / count + 1;
        if(totalPage == 0)
            totalPage = 1;

        return totalPage;
    }
}