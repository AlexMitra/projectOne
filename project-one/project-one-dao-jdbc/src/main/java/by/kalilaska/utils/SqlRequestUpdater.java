package by.kalilaska.utils;

public class SqlRequestUpdater {
	
	public static String getCompleteSql(String notReadySql, String...params){
		String completeSql = notReadySql;
		
		for (String param : params) {
			completeSql = completeSql.replaceFirst("\\:[\\w]+", "'" + param + "'");
		}
		System.out.println(completeSql);
		return completeSql;
	}

}
