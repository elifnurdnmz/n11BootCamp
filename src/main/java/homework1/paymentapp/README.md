# N11 BootCamp - Yeni Ödeme Yöntemi Entegrasyonu (Ödev 1)

Bu proje, bir ödeme ekranı uygulamasının SOLID prensipleri doğrultusunda tasarlanmış Java implementasyonudur. Temel amaç, mevcut sisteme (Kredi Kartı) yeni bir ödeme yöntemini (PayPal, Apple Pay vb.) kodu bozmadan entegre edebilmektir.

## Mimari Yapı ve Tasarım Kararları

Proje geliştirilirken aşağıdaki SOLID prensipleri uygulanmıştır:

### 1. Single Responsibility Principle (SRP)
Her sınıfın tek bir sorumluluğu vardır:
- `PaymentUI`: Sadece kullanıcı arayüzü.
- `PaymentService`: Ödeme sürecinin iş mantığı ve loglama.
- `AmountValidator`: Sadece tutar doğrulaması.
- `PaymentRegistry`: Ödeme yöntemlerinin merkezi yönetimi ve eşleştirilmesi.
- `DBRepo / FileRepo`: Veri kalıcılığı (Persistence).

### 2. Open/Closed Principle (OCP)
Sistem, yeni ödeme yöntemlerine açıktır ancak mevcut kodun değiştirilmesine kapalıdır. Yeni bir ödeme yöntemi eklemek için:
- `PaymentMethod` interface'inden yeni bir sınıf türetilir.
  Mevcut `PaymentService` veya `PaymentUI` sınıflarında hiçbir değişiklik yapılması gerekmez.
- `PaymentRegistry` sınıfı içerisinde **Java Reflection API** kullanılmıştır. Otomatik Kayıt (Auto-Registration) metodu oluşturulmuştur.
  Bu sayede, sisteme yeni bir ödeme yöntemi (sınıf) eklendiğinde, `PaymentRegistry` sınıfına gidip manuel olarak `put()` işlemi yapmaya gerek kalmaz. Sistem, çalışma zamanında (runtime) ilgili paketteki sınıfları tarar ve Enum değerleriyle eşleşen sınıfları otomatik olarak yükler.
### 3. Dependency Inversion Principle (DIP)
`PaymentService` ve `PaymentUI` somut sınıflara (örneğin doğrudan CreditCard sınıfına) bağımlı değildir. Bunun yerine `PaymentMethod` ve `PaymentRepository` arayüzlerine bağımlıdır.

### 4. Design Patterns
- Çalışma zamanında (runtime) kullanıcının seçtiği ödeme yöntemine göre farklı stratejilerin (`CreditCard`, `PayPal`, döviz cinsi vb.) çalıştırılması sağlanmıştır.
- Verinin nereye kaydedileceği (Veritabanı veya Dosya), iş mantığından tamamen soyutlanmıştır.
## Paket Yapısı
- `payment`: Ödeme stratejileri ve PaymentMethod arayüzü.
- `service`: İş mantığı. Loglama ve koordinasyon burada yapılır.
- `repo`: Veri saklama katmanı
- `ui`: Swing kütüphanesi ile hazırlanmış görsel arayüz.
- `validation`: Veri kontrol mekanizması.
- `exceptions`: Uygulamaya özgü hata tipleri.

## Kullanılan Teknolojiler
- **Java:** Dil temelinde OOP prensipleri.
- **Java Logging API:** Sistem izleme ve hata takibi.
- **Swing:** Masaüstü kullanıcı arayüzü.

## 👩🏻‍💻 Hazırlayan

Elifnur Dönmez

---
*Bu proje N11 BootCamp kapsamında ödev olarak hazırlanmıştır.*