//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
// inline function
    runAndPrint{message -> println(message)}

}

// inline function
inline fun runAndPrint(run: (String) -> Unit) {
    run("Message")
}

// inline ve noinline beraber
inline fun runAndPrint2(run: (String) -> Unit, noinline run2: (String) -> Unit) {

}




//#inline
// inline keyword u higher order functionslarda kullanıldığında bu fonksiyonun
// nesnesi oluşturulmaz direkt olarak fonksiyonun gövdesi yani {} arası çağırılır.
// bu durum da performans artışı sağlar. ama higher order function ın gövdesi
// uzun bir kod bloğu halinde ise inline fonksiyonu kullanımı önerilmez çünkü build time
// uzar ve performans kaybına neden olur. o yüzden fonksiyon gövdesi uzun değilse ve fonksiyon tekrar tekrar
// kullanılacaksa higher order function inline olarak tanımlanır ve performans artışı sağlanmış olur.


//#noinline
// örneğin higher order function parametre olarak 2 tane fonksiyon alıyorsa birisinin nesnesini oluşturmamız
// gerekiyor ise nesnesini oluşturmak istediğimiz parametre fonksiyonu başına noinline keyword u koyarız.
// örnek olarak bir inline fonksiyon tanımlıyorum ve 2 tane fonksiyon parametresi alıyor diyelim
//2. fonksiyon bir yerde inline olmadan tanımlanmış ise onu inline fonksiyonun parametresi olarak verdiğimizde
// nesnesini bekleyeceği için inline fonksiyonumuz çalışmaz. o yüzden
// ya o fonksiyonu da inline yapacağız ya da inline fonksiyonumuz içerisinde  ilgili fonksiyon parameresi başına noinline yazarız.

//#crossinline
// öncelikle NON LOCALE RETURN e bak.
// inline  olmayan bir high order fonksiyonda parametre olarak inline olan başka bir fonksiyon verdik diyelim.
// inline fonksiyonlar "non locale return" desteklediği için  return anahtar kelimesini yazdığımızda 2 fonksiyon birden dışarı çıkar
// ide bize diyor ki sen burda inline fonksiyon yapmışsın bu yüzden return kullanırsan non locale return olacak yani return
// 2 fonksiyon üste gidecek. Ama senin asıl fonksiyonun inline değil!
// biz de inline olan fonksiyon başına (yani lambda gösterim başına) crossinline koyuyoruz ki
// burada return anahtar kelimesi yazmayı yasaklamış oluyoruz. ideye de sana asla return değeri vermeyeceğim bak  crossinline yaptım
// diye verdiğimizde, ide de bize inline olmayan bir higher order fonksiyon içersinde inline bir fonksiyonu kullanmamıza izin veriyor.


