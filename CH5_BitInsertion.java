import java.io.*;

public class CH5_BitInsertion {

	public boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	public int setBit(int num, int i, boolean target) {
		if(target) {
			if(getBit(num,i))
				return num;
			else
				return (num | (1 << i));
		}
		else
		{
			if(!getBit(num,i))
				return num;
			else
				return (num & (~(1 << i)));
		}
	}
	
	public int insertBit(int num,int put, int a, int b) {
		int count = 0;
		int ret = num;
		for(int i=a; i<= b; i++) {
			boolean bit = getBit(put,count);
			ret = setBit(ret,i,bit);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		CH5_BitInsertion bit = new CH5_BitInsertion();
		System.out.println(bit.insertBit(63, 0, 2, 3));
	}
}
