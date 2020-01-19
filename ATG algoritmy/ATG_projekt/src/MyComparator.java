import java.util.Comparator;

class MyComparator implements Comparator<Vertex>
{
    @Override
    public int compare(Vertex o1,Vertex o2)
    {
        Integer int1 = o1.getVertex();
        Integer int2 = o2.getVertex();
        return int1.compareTo(int2);//sort in ascending order
    }
}