package patterns.templatemethod;

import static utils.Utils.println;

public class CompanyRepository extends JdbcTemplate<CompanyRepository.Company> {

    @Override
    protected String getDataSource() {
        println("Шаг получения dataSource");
        return "dataSource";
    }

    @Override
    protected Company mapResult(String result) {
        println("Шаг маппинга результата запроса на объект");
        return new Company();
    }

    public static class Company {}

}
