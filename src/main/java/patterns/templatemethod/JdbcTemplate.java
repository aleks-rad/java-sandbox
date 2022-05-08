package patterns.templatemethod;

import static utils.Utils.println;

public abstract class JdbcTemplate<T> {

    /**
     * Шаблонный метод
     * Алгоритм с частично реализованными шагами
     */
    public T query(String sql, Object... params){
        String dataSource = getDataSource();// необходимо реализовать в субклассе

        Connection connection = getConnection(dataSource);

        String preparedQuery = prepareQuery(sql, params);

        String result = connection.execute(preparedQuery);

        T objResult = mapResult(result); // необходимо реализовать в субклассе

        return objResult;
    }

    protected abstract String getDataSource();

    private Connection getConnection(String dataSource){
        println("Шаг получения connection");
        return new Connection();
    }

    private String prepareQuery(String sql, Object... params){
        println("Шаг подготовки запроса");
        return String.format(sql + "%n", params);
    }

    protected abstract T mapResult(String result);

    private static class Connection {
        String execute(String preparedQuery){
            println("Шаг выполнения запроса");
            println(preparedQuery);
            return "";
        }
    }

}
