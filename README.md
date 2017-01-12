OurIMDb klasörü C:\Workplace\ dizini altına kopyalanmalıdır.

Projenin çalışması için eklenmesi gereken kütüphaneler "External Jars" klasörü altındadır.

For SqlConnection
	- mysql-connector-java-5.1.40\mysql-connector-java-5.1.40-bin.jar

For WebBrowser:
	- DJNativeSwing-SWT-1-0-2\DJNativeSwing.jar
	- DJNativeSwing-SWT-1-0-2\DJNativeSwing-SWT.jar
	- native\swt.jar

Çalıştırmak için "MainForm.java" kullanılmalıdır.

UrlDownloadWithPeopleTitle ve MinimizeImages dosyalarınında mainleri mevcuttur, bunların kullanım
yeri raporda mevcurttur.

Veri tabanını yeniden oluşturmak için sırasıyla:
	Create Database.sql (Database ve tabloları oluşturmak için)
	Insert.sql (Filmleri eklemek için)
	xxx poeple.sql (ilgili filmin oyuncu bilgileri için)
	xxx moviePeople.sql (ilgili film ile oyuncu arasındaki bağlantılar için)
	Bu aşamadan sonra database de resimler null olacak şekilde oluşmuş olur
	
	Bu resimleri doldurmak için filmin resmini filmin ismiyle 
C:\Workplace\OurIMDb\DB\MovieOriginalImages klasörü altına kopyalanmanız gerekmekte.
	Kişilerin resimleri içinse sırasıyla UrlDownloadWithPeopleTitle ve MinimizeImages çağrıldığında
C:\Workplace\OurIMDb\DB\PeopleMinimizedImages içinde ilgili resimler oluşacaktır.

	Bu aşamalardan sonra MainForm içindeki NewMovieIn değeri true ya setlenerek program çalıştırılırsa
ilgili resimleri database eklemesi gerçekleştirilir.
