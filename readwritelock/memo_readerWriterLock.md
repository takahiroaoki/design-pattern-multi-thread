# Read Write Lockパターン

読んでいる最中にデータが書き換えられたり、書いている途中にデータを読んでしまうと、読み取ったデータが不整合なものになってしまうため、データの読み書きにも基本的に排他制御は必要になる。
しかし、杓子定規に排他制御を適用してしまうと、プログラムのパフォーマンスを大きく下げることにつながる。

実際には「読み取り」という作業はデータの状態を変化させないので、複数スレッドから読み取りを行う際には互いに排他制御をする必要はないはずである。そこで「読み取り×読み取り」の時には排他制御を行わないよう、ReadWriteLockというインスタンスで「論理による自前の排他制御」を行っている。複数スレッドから読み取りと書き込みが行われる際のこのような設計をRead Write Lockパターンと言う。

ReadeWriteLockクラスは、java.util.concurrent.Locksパッケージ配下のクラス類を使っても実現できる。

なお、このパターンは「読み取り処理の頻度が高く、時間もかかる」という際に最もパフォーマンス向上が期待できる。読み取りが書き込みに比べてほとんど一瞬で終わるようなシステムでは、Read Write Lockパターンを採用することにより複雑性が増してしまうので、synchronizedで読み取り同士でも排他制御をしてしまって良いこともある。

また、Read Write Lockパターンを採用する際、スレッドの数や実行頻度が「読み取り＞書き込み」であると、一向に書き込みが行われない可能性があるため、「書き込みスレッドが待機している時は書き込みスレッドを優先する」というように制御してやる必要がある。