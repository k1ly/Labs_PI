use jdbc;

go;
create procedure countUsersByMinAge(@minAge int, @count int output) as
begin
    select @count = count(*) from users where age >= @minAge;
end;

go;
begin
    declare @count int;
    exec countUsersByMinAge 22, @count output;
    select @count as count;
end;