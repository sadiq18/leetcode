package queue;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        //System.out.println(partCount);
        int partLength = n - (maxCount - 1);
        //System.out.println(partLength);
        int emptySlots = partCount * partLength;
        //System.out.println(emptySlots);
        int availableTasks = tasks.length - max * maxCount;
        //System.out.println(availableTasks);
        int idles = Math.max(0, emptySlots - availableTasks);
        //System.out.println(idles);
        return tasks.length + idles;
    }
	
	public static void main(String[] args) {
		TaskScheduler obj=new TaskScheduler();
		char tasks[]=new char[] {'A','A','A','B','B','B'};
		System.out.println(obj.leastInterval(tasks, 2));

	}

}
