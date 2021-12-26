# Immutableパターン

常に不変であることが保証されているクラスやインスタンスであれば、synchronized修飾子をつけずともどのスレッドから呼び出してもデータの不整合は起こり得ない。

immutableなクラスやインスタンスを作るためには、そのフィールドに使用した値なども不変であるや、親や子クラスからも変更されないことを保証する必要がある。今回の例でいうと、Stringもimmutableなインスタンスなので安心できる。

synchronizedではロックすることにより実行時間が長くなるため、immutableパターンを使用してsynchronizedを避けることでパフォーマンス向上にも貢献できる。たとえばimmutableではないインスタンスについても、利用のされ方を分析するとimmutableと見なしても良い使われ方があったりする。その際は対になるクラスを二つ用意し、immutableXX, mutableXXとすることでsynchronizedの利用頻度を減らし、パフォーマンスを向上できたりする。

StringとStringBufferなども実はimmutableとmutableの対のクラスである。