# Single Threaded Executionパターン

複数スレッドで利用される共有資源については、必ず1つのスレッドしか同時に利用できないよう指定することでデータの整合性を保つパターン。データの不整合が起こりうる箇所をCritical Sectionと呼ぶことから、Critical Sectionパターンとも呼ばれる。

今回の実装では、Gateインスタンスが共有資源ということになる。

共有資源の利用順序によってはデッドロックが起きてしまったり、継承を利用することによってサブクラスでは安全性が崩れてしまうこともあるので注意する。