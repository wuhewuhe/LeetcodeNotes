package Thread;

public class DameonThread {
	public static void main(String[] args) {
//		Thread daemonThread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {
//					System.out.println("hi daemon....");
//				}
//			}
//		});
//		daemonThread.start();
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("main thread is over!");
		
		
//		Thread daemonThread = new Thread(new Runnable() {
//			@Override
//			            public void run() {
//				while(true) {
//					System.out.println("hi Daemon....");
//				}
//			}
//		}
//		);
//		daemonThread.setDaemon(true);
//		daemonThread.start();
//		try {
//			Thread.sleep(1);
//		}
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("main thread is over!");
//			Thread thread1 = new MyCommon();
//			Thread thread2 = new MyDaemon();
//			thread2.setDaemon(true);
//			thread1.start();
//			thread2.start();


	}
	
	public class MyDaemon extends Thread {
		public void run() {
			for (int i = 0; i < 5000; ++i) {
				System.out.println("后台线程1第 " + i + " 次执行");
				try {
					Thread.sleep(7);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}



}
