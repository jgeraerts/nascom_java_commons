package be.nascom.commons.orm.hibernate3.cfg;

import org.hibernate.cfg.NamingStrategy;

/**
 * User: bart
 * Date: Jun 6, 2009
 * Time: 12:14:40 PM
 */
public class UppercaseTablesAndColumnsNamingStrategyDecorator implements NamingStrategy {
    private NamingStrategy strategy;

    public UppercaseTablesAndColumnsNamingStrategyDecorator() {
    }

    public UppercaseTablesAndColumnsNamingStrategyDecorator(NamingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NamingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String classToTableName(String className) {
        return strategy.classToTableName(className).toUpperCase();
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return strategy.propertyToColumnName(propertyName).toUpperCase();
    }

    @Override
    public String tableName(String tableName) {
        return strategy.tableName(tableName).toUpperCase();
    }

    @Override
    public String columnName(String columnName) {
        return strategy.columnName(columnName).toUpperCase();
    }

    @Override
    public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {
        return strategy.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName).toUpperCase();
    }

    @Override
    public String joinKeyColumnName(String joinedColumn, String joinedTable) {
        return strategy.joinKeyColumnName(joinedColumn, joinedTable).toUpperCase();
    }

    @Override
    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        return strategy.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName).toUpperCase();
    }

    @Override
    public String logicalColumnName(String columnName, String propertyName) {
        return strategy.logicalColumnName(columnName, propertyName).toUpperCase();
    }

    @Override
    public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName) {
        return strategy.logicalCollectionTableName(tableName, ownerEntityTable, associatedEntityTable, propertyName).toUpperCase();
    }

    @Override
    public String logicalCollectionColumnName(String columnName, String propertyName, String referencedColumn) {
        return strategy.logicalCollectionColumnName(columnName, propertyName, referencedColumn).toUpperCase();
    }
}
