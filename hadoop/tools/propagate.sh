cd $HADOOP_HOME
zip -r conf.zip conf
scp $HADOOP_HOME/conf.zip hadoop@pi0:opt/hadoop/
scp $HADOOP_HOME/conf.zip hadoop@pi1:opt/hadoop/
rm $HADOOP_HOME/conf.zip

ssh hadoop@pi0 "rm -rf $HADOOP_HOME/conf"
ssh hadoop@pi0 "unzip $HADOOP_HOME/conf.zip -d $HADOOP_HOME"
ssh hadoop@pi0 "rm $HADOOP_HOME/conf.zip"

ssh hadoop@pi1 "rm -rf $HADOOP_HOME/conf"
ssh hadoop@pi1 "unzip $HADOOP_HOME/conf.zip -d $HADOOP_HOME"
ssh hadoop@pi1 "rm $HADOOP_HOME/conf.zip"

