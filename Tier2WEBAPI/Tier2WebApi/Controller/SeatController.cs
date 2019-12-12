using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Packaging;
using System.Linq;
using System.Net.Http;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Tier2WebApi.DataModels;

namespace Tier2WebApi.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class SeatController : ControllerBase
    {
        private readonly SeatContext _context;
        public SeatController(SeatContext context)
        {
            _context = context;
        }

        //// GET: api/TodoItems
        //[HttpGet]
        //public async Task<ActionResult<IEnumerable<Seat>>> GetTodoItems()
        //{
        //    return await _context.seats.ToListAsync();
        //

        //// POST: api/Value
        //[HttpPost]
        //public void Post([FromBody] string value)
        //{
        //}
        //[HttpGet("{id}")]
        //public async Task<ActionResult<Seat>> GetSeat(int id)
        //{
        //    var todoItem = await _context.seats.FindAsync(id);


        //    if (todoItem == null)
        //    {
        //        return NotFound();
        //    }

        //    return todoItem;
        //}

        //[HttpPost("{id}")]
        //public async Task<ActionResult<Seat>> PostSeat([FromBody]Seat seat)
        //{

        //    _context.seats.Add(seat);
        //    await _context.SaveChangesAsync();

        //    return CreatedAtAction(nameof(GetSeat), new { id = seat.id }, seat);


        //}


        [HttpPost]
        public async Task<IActionResult> Post([FromBody]string[] content)
        {
            string username, password, confpas, email;
            username = content[0];
            password = content[1];
            confpas = content[2];
            email = content[3];

            if (password.Equals(confpas))
            {
                RegisterClientTDB(username, password, email);
                return Ok("Everything is fine");
            }
            return BadRequest("u suck");
        }



        public void RegisterClientTDB(string username, string password, string email)
        {
            string ip = "localhost";
            int port = 3344;

            ClientReg client = new ClientReg();
            client.username = username;
            client.password = password;
            client.email = email;

            TcpClient connection = new TcpClient(ip, port);

            string[] package = { client.username, client.password, client.email };

            NetworkStream stream = connection.GetStream();

            string serialized_package = JsonConvert.SerializeObject(package);

            byte[] buffer = new byte[1024];

            buffer = Encoding.UTF8.GetBytes(serialized_package);

            stream.Write(buffer, 0, buffer.Length);

            stream.Flush();

            Console.WriteLine("Data sent ");
        }



    }
}
