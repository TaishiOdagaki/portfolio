DROP DATABASE IF EXISTS sample;
DROP USER IF EXISTS taishi;
CREATE USER taishi WITH PASSWORD 'taishi1985';
CREATE DATABASE sample OWNER taishi ENCODING 'UTF8';
\c sample

DROP TABLE IF EXISTS item;

CREATE TABLE item
(
  code SERIAL PRIMARY KEY,
  category_code INTEGER ,
  name TEXT,
  price INTEGER,
  level INTEGER,
  popularity INTEGER,
  image TEXT,
  information TEXT
);

INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, 'スッキリわかるJava入門 第2版', 2808, 1, 4, 'スッキリわかるJava入門 第2版.jpg', 'プログラミング学習のネックとなる「開発環境の準備」と「多発するエラーへの対応」には、ブラウザ上でコーディング、コンパイル、実行ができる仮想開発環境「dokojava」を読者特典として用意し、エラーによく効く「虎の巻」を巻末付録として用意しました。本書でぜひ、Javaプロフェッショナルへの第一歩を踏みだしてください! ');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, 'やさしいJava 第7版', 2786, 2, 2, 'やさしいJava.jpg', '文法の基礎からクラス、オブジェクト指向まで、しっかりと理解できる構成で、無理なく読み進められる書籍です。わかりやすく、読みやすい解説と、動かして理解できる多数のサンプルプログラムで、大切な基本がきちんと身につきます。最新のJava環境であるJava 11に対応し、OpenJDKを使った環境構築も紹介しています。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, 'Javaの教科書', 2160, 2, 3, 'Javaの教科書.jpg', '「Java」は、スタンドアロンやネットワーククライアント環境をはじめ、サーバサイド、あるいはモバイル環境にいたるまでのアプリケーションの開発に利用されるようになりました。本書は、これら開発のすべてに共通して必要な、プログラムの制御構造とアルゴリズムを学びながらJava言語の文法を習得する流れになっています。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, '新・明解Java入門', 2916, 1, 5, '新明解Java入門.jpg', '『新・明解C言語 入門編』の柴田望洋が贈る、最も明解で最も平易なJava解説書。たくさんの図表と、サンプルプログラムを使って、Javaの基礎から、オブジェクト指向プログラミングの本質を、わかりやすく解き明かす。また、今回の改訂要素として、新章「例外処理」が加わります。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, '徹底攻略 Java SE 7/8 Bronze 問題集', 2700, 2, 3, '徹底攻略.jpg', 'Webからダウンロードできる模擬問題60問を付属した合計256問を収録。初心者でも基礎を身に付けられるように配慮された問題構成と、初心者がつまづきやすい部分をていねいに説明した解説が、他にはない特徴です。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(1, 'オラクル認定資格教科書 Javaプログラマ Silver SE 8 ', 4104, 3, 5, 'オラクル認定資格教科書.jpg', 'Java初心者にもわかりやすいように、Javaプログラミングの基礎からオブジェクト指向の基礎知識まで丁寧に解説。サンプルコードはすべてダウンロード可能。コンピュータ上で実際に動かして、動作を確認しながら学習できる。章末には豊富な練習問題を掲載。各章で学習したことをすぐにチェック。本番前の総仕上げ・腕試しに、本試験と同じ60問の模擬試験を巻末に収録。試験直前の確認に有効な、重要事項をまとめたチェックシート付き。');


INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, 'よくわかるPHPの教科書', 2678, 1, 2, 'よくわかるPHPの教科書.jpg', 'やさしい言葉で分かりやすく書かれているので、プログラミングの用語やコードに拒否感がある人でも、すいすい読み進めることができます。プログラミングの本を読むのが気が進まない人にとっても、「この本だけは最後まで読めた」と言っていただける1冊です。 本書でぜひ、PHPプロフェッショナルへの第一歩を踏みだしてください! ');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, 'PHPの絵本 ', 1814, 1, 3, '絵本.jpg', '「PHPは初めて」「アプリケーションって難しそう」という方にも、そもそもプログラムとはどんなものなのかというところから学んでもらえるように配慮されています。機能的にも充実したPHPの最新事情もフォローし、充実したアプリケーション作りの第一歩をここから踏み出すことができます');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, '詳細! PHP 7+MySQL 入門ノート', 3218, 3, 3, '詳細！　PHP7.jpg', '本書は、2015年に5.xから7へとバージョンアップした最新のPHPについて、プログラマとしての道をスタートしようという人、他のプログラム言語の経験はあるがPHPはきちんと学んだことがないという人を対象にし、詳しいコード注釈と図解を使って丁寧にわかりやすく解説を行なっています。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, 'PHPフレームワーク Laravel Webアプリケーション開発 バージョン5.5 LTS対応', 3240, 2, 4, 'フレームワーク.jpg', '本書は、Laravelのインストールから、フレームワークの中心になるModel-View-Controller（MVC）の使い方、開発に役立つ各種機能をわかりやすく解説した入門書です。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, 'PHP7＋MariaDB／MySQLマスターブック', 2678, 3, 3, 'マリア.jpg', '本書1冊でPHPとMariaDB／MySQLの基本とWebアプリケーションの構築法について実践的に学習できます。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(2, 'PHP逆引きレシピ', 3218, 2, 2, '詳細！　PHP7.jpg', '最新PHPに対応! さらにレシピを拡充し、より便利に! PHP初級者が中級者にレベルアップするための実践的なプログラミングレシピ集『PHP逆引きレシピ』の改訂第2版です。第2版では、最新のPHP(5.4/5.5)に対応したほか、レシピ全体の大幅な見直しを行い、データベースやテスト関連のレシピ拡充など、さらに内容充実・より便利になりました。');


INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, 'やさしいC++ 第5版', 2786, 1, 3, 'やさしいC＋＋.jpg', 'プログラミング教科書のベストセラー、高橋麻奈の「やさしい」シリーズの『やさしいC++』を、新装丁+スッキリとした本文デザインで、より親しみやすく、より読みやすく改訂します。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, '独習C++ 第4版', 3456, 2, 2, '独習C++.jpg', '文C++学習書の大定番を、来るべき新規格C++0xへの対応に備え、各種の記述内容を見直すとともに、コンパイラも新規格への対応の進んでいるGCCの新バージョンに改めました。移り変わりの激しいPC書の棚にあって、永く活用していただける「アンカー（錨）」として役立ててもらいたい1冊です。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, 'C++ポケットリファレンス', 3218, 3, 4, 'C++ポケットリファレンス.jpg', '「逆引き形式で目的からすぐ探せる」「サンプルコードを見ながら具体的な実装のイメージがつかめ」という特徴はそのままに、C++11以来のメジャーアップデートとなったC++17に対応しました。構造化束縛などのコア言語の新機能や、optional、variantなどの解説を追加。もちろん、現場で長く使われているC++03にも対応しています。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, 'Modern C++チャレンジ', 3300, 2, 3, 'モダン.jpg', '数学の問題から、文字列処理、日付と時刻、並行処理、暗号、ネットワークまで、多岐にわたる100の問題を集め、その解法をC++で示します。ポピュラーで古典的な数学の問題をはじめ、C++17でのファイル操作やC++20での実行時間の計測、デザインパターン、テキスト翻訳、画像から顔検出など、身近で興味のわく魅力的な問題が多数収録されています。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, 'Effective C++ ', 4104, 2, 2, 'Effective C++.jpg', '本書は、1991年の初版以来、C++プログラマから絶大な支持を得てきた『Effective C++』の、内容を新たにした改訂第3版の翻訳書です。第3版においても、C++の効率的な使い方を紹介するのが、変わらない本書の目的です。');
INSERT INTO item(category_code, name, price, level, popularity, image, information) VALUES(3, 'Optimized C++ ―最適化、高速化のためのプログラミングテクニック ', 4320, 3, 5, '最適化.jpg', '本書は性能に影響する要因の特性をしっかり理解し、正しく測定することによって性能上の問題を引き起こしている「ホットスポット」を特定し、どのような最適化が可能であり、採用すべきなのかを詳しく解説します。');







DROP TABLE IF EXISTS category;

CREATE TABLE category
(
  code SERIAL PRIMARY KEY,
  name TEXT
);

INSERT INTO category(name) VALUES('Java');
INSERT INTO category(name) VALUES('PHP');
INSERT INTO category(name) VALUES('C++');







DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
  code SERIAL PRIMARY KEY,
  name TEXT,
  address TEXT,
  tel TEXT,
  email TEXT
);




DROP TABLE IF EXISTS ordered;


CREATE TABLE ordered
(
  code SERIAL PRIMARY KEY,
  customer_code INTEGER,
  ordered_date DATE,
  total_price INTEGER
);




DROP TABLE IF EXISTS ordered_detail;

CREATE TABLE ordered_detail
(
  ordered_code INTEGER,
  item_code INTEGER,
  num INTEGER
); 



GRANT SELECT ON ALL TABLES IN SCHEMA public TO taishi;

ALTER TABLE item OWNER TO taishi;
ALTER TABLE category OWNER TO taishi;
ALTER TABLE customer OWNER TO taishi;
ALTER TABLE ordered OWNER TO taishi;
ALTER TABLE ordered_detail OWNER TO taishi;
