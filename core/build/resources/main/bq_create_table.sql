CREATE TABLE `foodmart`.`sales_fact_1997` (
        `product_id` int64 ,
        `time_id` int64 ,
        `customer_id` int64 ,
        `promotion_id` int64 ,
        `store_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 
    );

CREATE TABLE `foodmart`.`sales_fact_1998` (
        `product_id` int64 ,
        `time_id` int64 ,
        `customer_id` int64 ,
        `promotion_id` int64 ,
        `store_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 
    );

CREATE TABLE `foodmart`.`sales_fact_dec_1998` (
        `product_id` int64 ,
        `time_id` int64 ,
        `customer_id` int64 ,
        `promotion_id` int64 ,
        `store_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 
    );

CREATE TABLE `foodmart`.`inventory_fact_1997` (
        `product_id` int64 ,
        `time_id` int64,
        `warehouse_id` int64,
        `store_id` int64,
        `units_ordered` int64,
        `units_shipped` int64,
        `warehouse_sales` FLOAT64,
        `warehouse_cost` FLOAT64,
        `supply_time` SMALLINT,
        `store_invoice` FLOAT64
    );

CREATE TABLE `foodmart`.`inventory_fact_1998` (
        `product_id` int64 ,
        `time_id` int64,
        `warehouse_id` int64,
        `store_id` int64,
        `units_ordered` int64,
        `units_shipped` int64,
        `warehouse_sales` FLOAT64,
        `warehouse_cost` FLOAT64,
        `supply_time` SMALLINT,
        `store_invoice` FLOAT64
    );

CREATE TABLE `foodmart`.`agg_pl_01_sales_fact_1997` (
        `product_id` int64 ,
        `time_id` int64 ,
        `customer_id` int64 ,
        `store_sales_sum` FLOAT64 ,
        `store_cost_sum` FLOAT64 ,
        `unit_sales_sum` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_ll_01_sales_fact_1997` (
        `product_id` int64 ,
        `time_id` int64 ,
        `customer_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_l_03_sales_fact_1997` (
        `time_id` int64 ,
        `customer_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_l_04_sales_fact_1997` (
        `time_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `customer_count` int64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_l_05_sales_fact_1997` (
        `product_id` int64 ,
        `customer_id` int64 ,
        `promotion_id` int64 ,
        `store_id` int64 ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_c_10_sales_fact_1997` (
        `month_of_year` SMALLINT ,
        `quarter` string ,
        `the_year` SMALLINT ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `customer_count` int64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_c_14_sales_fact_1997` (
        `product_id` int64 ,
        `customer_id` int64 ,
        `store_id` int64 ,
        `promotion_id` int64 ,
        `month_of_year` SMALLINT ,
        `quarter` string ,
        `the_year` SMALLINT ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_lc_100_sales_fact_1997` (
        `product_id` int64 ,
        `customer_id` int64 ,
        `quarter` string ,
        `the_year` SMALLINT ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_c_special_sales_fact_1997` (
        `product_id` int64 ,
        `promotion_id` int64 ,
        `customer_id` int64 ,
        `store_id` int64 ,
        `time_month` SMALLINT ,
        `time_quarter` string ,
        `time_year` SMALLINT ,
        `store_sales_sum` FLOAT64 ,
        `store_cost_sum` FLOAT64 ,
        `unit_sales_sum` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_g_ms_pcat_sales_fact_1997` (
        `gender` string ,
        `marital_status` string ,
        `product_family` string,
        `product_department` string,
        `product_category` string,
        `month_of_year` SMALLINT ,
        `quarter` string ,
        `the_year` SMALLINT ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `customer_count` int64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`agg_lc_06_sales_fact_1997` (
        `time_id` int64 ,
        `city` string ,
        `state_province` string ,
        `country` string ,
        `store_sales` FLOAT64 ,
        `store_cost` FLOAT64 ,
        `unit_sales` FLOAT64 ,
        `fact_count` int64 
    );

CREATE TABLE `foodmart`.`currency` (
        `currency_id` int64 ,
        `date` DATE ,
        `currency` string ,
        `conversion_ratio` FLOAT64 
    );

CREATE TABLE `foodmart`.`account` (
        `account_id` int64 ,
        `account_parent` int64,
        `account_description` string,
        `account_type` string ,
        `account_rollup` string ,
        `Custom_Members` string
    );

CREATE TABLE `foodmart`.`category` (
        `category_id` string ,
        `category_parent` string,
        `category_description` string ,
        `category_rollup` string
    );

CREATE TABLE `foodmart`.`customer` (
        `customer_id` int64 ,
        `account_num` BIGINT ,
        `lname` string ,
        `fname` string ,
        `mi` string,
        `address1` string,
        `address2` string,
        `address3` string,
        `address4` string,
        `city` string,
        `state_province` string,
        `postal_code` int64 ,
        `country` string ,
        `customer_region_id` int64 ,
        `phone1` string ,
        `phone2` string ,
        `birthdate` DATE ,
        `marital_status` string ,
        `yearly_income` string ,
        `gender` string ,
        `total_children` SMALLINT ,
        `num_children_at_home` SMALLINT ,
        `education` string ,
        `date_accnt_opened` DATE ,
        `member_card` string,
        `occupation` string,
        `houseowner` BOOLEAN,
        `num_cars_owned` int64,
        `fullname` string 
    );

CREATE TABLE `foodmart`.`days` (
        `day` int64 ,
        `week_day` string 
    );

CREATE TABLE `foodmart`.`department` (
        `department_id` int64 ,
        `department_description` string 
    );

CREATE TABLE `foodmart`.`employee` (
        `employee_id` int64 ,
        `full_name` string ,
        `first_name` string ,
        `last_name` string ,
        `position_id` int64,
        `position_title` string,
        `store_id` int64 ,
        `department_id` int64 ,
        `birth_date` DATE ,
        `hire_date` TIMESTAMP,
        `end_date` string,
        `salary` FLOAT64 ,
        `supervisor_id` int64,
        `education_level` string ,
        `marital_status` string ,
        `gender` string ,
        `management_role` string
    );

CREATE TABLE `foodmart`.`employee_closure` (
        `employee_id` int64 ,
        `supervisor_id` int64 ,
        `distance` int64
    );

CREATE TABLE `foodmart`.`expense_fact` (
        `store_id` int64 ,
        `account_id` int64 ,
        `exp_date` TIMESTAMP ,
        `time_id` int64 ,
        `category_id` string ,
        `currency_id` int64 ,
        `amount` FLOAT64 
    );

CREATE TABLE `foodmart`.`position` (
        `position_id` int64 ,
        `position_title` string ,
        `pay_type` string ,
        `min_scale` FLOAT64 ,
        `max_scale` FLOAT64 ,
        `management_role` string 
    );

CREATE TABLE `foodmart`.`product` (
        `product_class_id` int64 ,
        `product_id` int64 ,
        `brand_name` string,
        `product_name` string ,
        `SKU` BIGINT ,
        `SRP` FLOAT64,
        `gross_weight` FLOAT64,
        `net_weight` FLOAT64,
        `recyclable_package` BOOLEAN,
        `low_fat` BOOLEAN,
        `units_per_case` SMALLINT,
        `cases_per_pallet` SMALLINT,
        `shelf_width` FLOAT64,
        `shelf_height` FLOAT64,
        `shelf_depth` FLOAT64
    );

CREATE TABLE `foodmart`.`product_class` (
        `product_class_id` int64 ,
        `product_subcategory` string,
        `product_category` string,
        `product_department` string,
        `product_family` string
    );

CREATE TABLE `foodmart`.`promotion` (
        `promotion_id` int64 ,
        `promotion_district_id` int64,
        `promotion_name` string,
        `media_type` string,
        `cost` FLOAT64,
        `start_date` TIMESTAMP,
        `end_date` TIMESTAMP
    );

CREATE TABLE `foodmart`.`region` (
        `region_id` int64 ,
        `sales_city` string,
        `sales_state_province` string,
        `sales_district` string,
        `sales_region` string,
        `sales_country` string,
        `sales_district_id` int64
    );

CREATE TABLE `foodmart`.`reserve_employee` (
        `employee_id` int64 ,
        `full_name` string ,
        `first_name` string ,
        `last_name` string ,
        `position_id` int64,
        `position_title` string,
        `store_id` int64 ,
        `department_id` int64 ,
        `birth_date` TIMESTAMP ,
        `hire_date` TIMESTAMP,
        `end_date` TIMESTAMP,
        `salary` FLOAT64 ,
        `supervisor_id` int64,
        `education_level` string ,
        `marital_status` string ,
        `gender` string 
    );

CREATE TABLE `foodmart`.`salary` (
        `pay_date` TIMESTAMP ,
        `employee_id` int64 ,
        `department_id` int64 ,
        `currency_id` int64 ,
        `salary_paid` FLOAT64 ,
        `overtime_paid` FLOAT64 ,
        `vacation_accrued` FLOAT64 ,
        `vacation_used` FLOAT64 
    );

CREATE TABLE `foodmart`.`store` (
        `store_id` int64 ,
        `store_type` string,
        `region_id` int64,
        `store_name` string,
        `store_number` int64,
        `store_street_address` string,
        `store_city` string,
        `store_state` string,
        `store_postal_code` int64,
        `store_country` string,
        `store_manager` string,
        `store_phone` string,
        `store_fax` string,
        `first_opened_date` TIMESTAMP,
        `last_remodel_date` TIMESTAMP,
        `store_sqft` int64,
        `grocery_sqft` int64,
        `frozen_sqft` int64,
        `meat_sqft` int64,
        `coffee_bar` BOOLEAN,
        `video_store` BOOLEAN,
        `salad_bar` BOOLEAN,
        `prepared_food` BOOLEAN,
        `florist` BOOLEAN
    );

CREATE TABLE `foodmart`.`store_ragged` (
        `store_id` int64 ,
        `store_type` string,
        `region_id` int64,
        `store_name` string,
        `store_number` int64,
        `store_street_address` string,
        `store_city` string,
        `store_state` string,
        `store_postal_code` string,
        `store_country` string,
        `store_manager` string,
        `store_phone` string,
        `store_fax` string,
        `first_opened_date` TIMESTAMP,
        `last_remodel_date` TIMESTAMP,
        `store_sqft` int64,
        `grocery_sqft` int64,
        `frozen_sqft` int64,
        `meat_sqft` int64,
        `coffee_bar` BOOLEAN,
        `video_store` BOOLEAN,
        `salad_bar` BOOLEAN,
        `prepared_food` BOOLEAN,
        `florist` BOOLEAN
    );

CREATE TABLE `foodmart`.`time_by_day` (
        `time_id` int64 ,
        `the_date` TIMESTAMP,
        `the_day` string,
        `the_month` string,
        `the_year` SMALLINT,
        `day_of_month` SMALLINT,
        `week_of_year` int64,
        `month_of_year` SMALLINT,
        `quarter` string,
        `fiscal_period` string
    );

CREATE TABLE `foodmart`.`warehouse` (
        `warehouse_id` int64 ,
        `warehouse_class_id` int64,
        `stores_id` int64,
        `warehouse_name` string,
        `wa_address1` string,
        `wa_address2` string,
        `wa_address3` string,
        `wa_address4` string,
        `warehouse_city` string,
        `warehouse_state_province` string,
        `warehouse_postal_code` string,
        `warehouse_country` string,
        `warehouse_owner_name` string,
        `warehouse_phone` string,
        `warehouse_fax` string
    );

CREATE TABLE `foodmart`.`warehouse_class` (
        `warehouse_class_id` int64 ,
        `description` string
    );