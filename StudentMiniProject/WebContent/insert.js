function isValid(form)
{
	var sid=form.s_id;
	var sname=form.s_name;
	var sadd=form.s_add;
	if (check(sid)&& isNumber(sid)&&check(sname)&&check(sadd))
		{
			return true;
		}
	else
		{
			return false;
		}
}
function check(cmd)
{
	if(cmd.value=="")
		{
		alert("* marked field can not be empty");
		cmd.focus();
		return false;
		}
	else
		{return true;}
}
function isNumber(cmd)
{
	if(isNAN(cmd))
		{
		alert("student ID must be numbers only");
		cmd.focus();
		return false;
		}
	return true;
}
