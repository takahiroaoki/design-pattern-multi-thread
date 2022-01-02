# Thread Per Messageパターン

メインスレッドから、させたい処理ごとにスレッドを起動し、メインスレッドは次の処理に移るパターン。

Webサーバーなど、ユーザーへの応答性を上げる必要がある際に使われる。
実際にはスレッドの起動にもある程度時間がかかるので、その処理自体の重さとスレッド起動にかかる重さとを考慮に入れたうえで導入を検討する。またその性質上、「スレッド間で処理の順序を問わない場合」で「戻り値が不要な場合（イベントの通知等）」でのみ利用できる。